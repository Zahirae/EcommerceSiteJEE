package dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import Beans.Article;

import com.mysql.jdbc.Connection;

public class ArticleDao {
	 Connection con = (Connection) Connexion.getInstance();

	    public boolean add(Article a)
	    {
	        try
	        {
	            String req = "INSERT INTO article(`idArticle`, `libelle`, `description`, `prix`, `image`, `stock`)"
	                    + " VALUES (NULL , '" + a.getLibelle() + "', '" + a.getDescription() + "', '" + a.getPrix() + "', '" + a.getImage() + "', '" + a.getStock() + "');";

	            Statement st = con.createStatement();

	            int rs = st.executeUpdate(req);

	            if (rs > 0)
	            {
	                return true;
	            }

	        } catch (Exception e1)
	        {
	            // TODO Auto-generated catch block
	            e1.printStackTrace();
	        }

	        return false;
	    }

	    public boolean remove(int idArticle)
	    {
	        try
	        {
	            String req = "DELETE FROM article " + "WHERE idArticle = " + idArticle;

	            Statement st = con.createStatement();

	            int rs = st.executeUpdate(req);

	            if (rs > 0)
	            {
	                return true;
	            }

	        } catch (Exception e1)
	        {
	            e1.printStackTrace();
	        }

	        return false;
	    }

	    public boolean update(Article a)
	    {
	        try
	        {
	            String req = "UPDATE `ecommerce`.`article` "
	                    + "SET `libelle`='" + a.getLibelle() + "', "
	                    + "`description`='" + a.getDescription() + "', "
	                    + "`prix`='" + a.getPrix() + "', "
	                    + "`image`='" + a.getImage() + "', "
	                    + "`stock`='" + a.getStock() + "' "
	                    + "WHERE `idArticle`='" + a.getIdArticle() + "';";

	            Statement st = con.createStatement();

	            int rs = st.executeUpdate(req);

	            if (rs > 0)
	            {
	                return true;
	            }

	        } catch (Exception e1)
	        {
	            // TODO Auto-generated catch block
	            e1.printStackTrace();
	        }

	        return false;
	    }

	    public Article findByID(int id)
	    {
	        String req = "SELECT* " + " FROM article " + " WHERE idArticle = " + id;

	        try
	        {
	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery(req);

	            Article e = null;

	            if (rs.next())
	            {
	                //Article(int idArticle, String libelle, String desc, double prix, String img, int stock)

	                e = new Article(rs.getInt(1), rs.getString(2), rs.getString(3),
	                        rs.getDouble(4), rs.getString(5), rs.getInt(6));
	            }
	            return e;

	        } catch (Exception e)
	        {
	            e.printStackTrace();
	        }

	        return null;
	    }

	    public Vector<Article> findAll()
	    {
	        String req = "SELECT* " + " FROM article ";

	        Vector <Article> vect = null;

	        try
	        {
	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery(req);

	            while (rs.next())
	            {

	                if (vect == null)
	                {
	                    vect = new Vector<Article>();
	                }

	                Article e = new Article(rs.getInt(1), rs.getString(2), rs.getString(3),
	                        rs.getDouble(4), rs.getString(5), rs.getInt(6));

	                vect.add(e);
	            }

	            return vect;
	        } catch (Exception e)
	        {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }

	        return null;
	    }

	    
	    public Vector<Article> findAll(String key)
	    {
	        String req = "SELECT* " + " FROM article WHERE libelle like '%"+key+"%'";

	        Vector<Article> vect = null;

	        try
	        {
	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery(req);

	            while (rs.next())
	            {

	                if (vect == null)
	                {
	                    vect = new Vector<Article>();
	                }

	                Article e = new Article(rs.getInt(1), rs.getString(2), rs.getString(3),
	                        rs.getDouble(4), rs.getString(5), rs.getInt(6));

	                vect.add(e);
	            }

	            return vect;
	        } catch (Exception e)
	        {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }

	        return null;
	    }


	     public Vector<Article> findRandom(int nbMax)
	    {
	        String req = "SELECT* " + " FROM article ORDER BY RAND() LIMIT " + nbMax;

	        Vector<Article> vect = null;

	        try
	        {
	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery(req);

	            while (rs.next())
	            {

	                if (vect == null)
	                {
	                    vect = new Vector<Article>();
	                }

	                Article e = new Article(rs.getInt(1), rs.getString(2), rs.getString(3),
	                        rs.getDouble(4), rs.getString(5), rs.getInt(6));

	                vect.add(e);
	            }

	            return vect;
	        } catch (Exception e)
	        {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }

	        return null;
	    }

}
