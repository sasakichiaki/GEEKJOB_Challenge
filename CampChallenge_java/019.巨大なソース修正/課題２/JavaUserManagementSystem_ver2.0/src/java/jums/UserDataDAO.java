package jums;

import base.DBManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * ユーザー情報を格納するテーブルに対しての操作処理を包括する
 * DB接続系はDBManagerクラスに一任
 * 基本的にはやりたい1種類の動作に対して1メソッド
 * @author hayashi-s
 */
public class UserDataDAO {
    
    //インスタンスオブジェクトを返却させてコードの簡略化
    public static UserDataDAO getInstance(){
        return new UserDataDAO();
    }
    
    /**
     * データの挿入処理を行う。現在時刻は挿入直前に生成
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     */
    public void insert(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            st =  con.prepareStatement("INSERT INTO user_t(name,birthday,tell,type,comment,newDate) VALUES(?,?,?,?,?,?)");
            st.setString(1, ud.getName());
            st.setDate(2, new java.sql.Date(ud.getBirthday().getTime()));//指定のタイムスタンプ値からSQL格納用のDATE型に変更
            st.setString(3, ud.getTell());
            st.setInt(4, ud.getType());
            st.setString(5, ud.getComment());
            st.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            st.executeUpdate();
            System.out.println("insert completed");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }

    public void update(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            //セットする文章を変更//大文字でも小文字でもオッケだった
            //文章動作確認済み
//            "update user_t set name=?,birthday=?,tell=?,type=?,comment=?,newDate=? where UserID=?"
            st =  con.prepareStatement("update user_t set name=?,birthday=?,tell=?,type=?,comment=?,newDate=? where UserID=?");
            st.setString(1, ud.getName());
            st.setDate(2, new java.sql.Date(ud.getBirthday().getTime()));//指定のタイムスタンプ値からSQL格納用のDATE型に変更
            st.setString(3, ud.getTell());
            st.setInt(4, ud.getType());
            st.setString(5, ud.getComment());
            st.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            //７こめの？のユーザーIDを追加
            st.setInt(7, ud.getUserID());
            st.executeUpdate();
            //うまくできたら表示
            System.out.println("update completed");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }
    
    /**
     * データの更新処理を行う。
     * //データの挿入処理を参考
     *@param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     */    


    
    /**
     * データの削除処理を行う。
     *@param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     */    
        
        //int IDを引数として取得
        public void delete(int deleteID) throws SQLException {
        
        //既存のものを参照
        Connection con = null;
        PreparedStatement st = null;
        
        
        try {
            con = DBManager.getConnection();
            
            //ここから削除処理//
            //削除文を製作
            st = con.prepareStatement("delete from user_t where UserID=?");
            //？に削除対象のidをセット
            st.setInt(1, deleteID);
            //削除対象のidを削除
            //参考サイト
            //https://www.javadrive.jp/servlet/database/index7.html
            st.executeUpdate();
            //うまく行けばdelete completedと表示
            System.out.println("delete completed");

            //ここは既存のもの
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new SQLException(e);
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }
    
    
    
    
    /**
     * データの検索処理を行う。
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     * @return 検索結果
     */
    
    //欲しい情報は複数あるので。arraylistに変更！
    public ArrayList<UserDataDTO> search(UserDataDTO ud) throws SQLException{

        //ローカルホストに接続
        Connection con = null;
        //高速処理
        PreparedStatement st = null;
        
        
        try{
            
            //最後のreturn用のarraylist〜ResultSteへ
            ArrayList<UserDataDTO> resultList = new ArrayList<UserDataDTO>();
            //データベースコネクションを取得する
            con = DBManager.getConnection();
            
            
            //ユーザー一覧を表示
            String sql = "SELECT * FROM user_t";
            boolean flag = false;
            
            //nameが入力されていないとエラーが起きてしまうためそれを回避するためのboolean
            boolean flName = false;
            boolean flBirthday = false;
            boolean flType = false;
            
            //文字検索用の文字を生成するための式を作る！
            
            //SELECT 列名 FROM テーブル名 where 列名 LIKE '探索文字';
            //もし、nameが未入力じゃないなら
            if (!ud.getName().equals("")) {
                sql += " WHERE name like ?";
                flag = true;
                flName = true;
            }
            
            if (ud.getBirthday()!=null) {
                //この時点でnameが入力されていたらANDへ一番ん最初ならWHEREへ
                if(!flag){
                    sql += " WHERE birthday like ?";
                    flag = true;
                }else{
                    sql += " AND birthday like ?";
                }
                flBirthday = true;
            }
            
            if (ud.getType()!=0) {
                if(!flag){
                    sql += " WHERE type like ?";
                    flag = true;
                }else{
                    sql += " AND type like ?";
                }
                flType = true;
            }
            
            //先ほど生成したsqlを使用
            //参考サイト
            //https://www.javadrive.jp/servlet/database/index10.html
            st =  con.prepareStatement(sql);
            //まずフォームが空の場合はsetを行わないようにifで分岐
            //このiはnameが一番じゃない可能性があるため。
            int i = 1;
            if(flag) {
                //他との検索よけ
                if(flName){
                    st.setString(i, "%"+ud.getName()+"%");
                    i++;
                }
                if (flBirthday){
                    st.setString(i, "%"+ new SimpleDateFormat("yyyy").format(ud.getBirthday())+"%");
                    i++;
                }
                if (flType){
                    st.setInt(i, ud.getType());
                }
            }
            
            //引数にはデータベースに送りたいSQL文が書かれた文字列を指定します。"executeQuery"メソッドを実行した結果、データベースから何らかの結果が帰ってくる場合には「ResultSet」インターフェースのオブジェクトとして取得できます。
            //参考サイト
            //https://www.javadrive.jp/servlet/database/index6.html
            ResultSet rs = st.executeQuery();
            
            //データベースと検証(while)
            while(rs.next()){
                UserDataDTO resultUd = new UserDataDTO();
                resultUd.setUserID(rs.getInt(1));
                resultUd.setName(rs.getString(2));
                resultUd.setBirthday(rs.getDate(3));
                resultUd.setTell(rs.getString(4));
                resultUd.setType(rs.getInt(5));
                resultUd.setComment(rs.getString(6));
                resultUd.setNewDate(rs.getTimestamp(7));
                //最後にreturnにできるように最初に作ったarrayListに追加
                resultList.add(resultUd);
            }
            
            System.out.println("search completed");

            //先ほどadd下のをリターンで返してあげる！
            return resultList;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }
    
    /**
     * ユーザーIDによる1件のデータの検索処理を行う。
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     * @return 検索結果
     */
    public UserDataDTO searchByID(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            
            String sql = "SELECT * FROM user_t WHERE userID = ?";
            
            st =  con.prepareStatement(sql);
            st.setInt(1, ud.getUserID());
            
            ResultSet rs = st.executeQuery();
            rs.next();
            UserDataDTO resultUd = new UserDataDTO();
            resultUd.setUserID(rs.getInt(1));
            resultUd.setName(rs.getString(2));
            resultUd.setBirthday(rs.getDate(3));
            resultUd.setTell(rs.getString(4));
            resultUd.setType(rs.getInt(5));
            resultUd.setComment(rs.getString(6));
            resultUd.setNewDate(rs.getTimestamp(7));
            
            System.out.println("searchByID completed");

            return resultUd;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }
}
