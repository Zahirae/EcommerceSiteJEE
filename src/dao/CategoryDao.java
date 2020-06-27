package dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import Beans.Categorie;

import com.mysql.jdbc.Connection;

public class CategoryDao {
	Connection con = (Connection) Connexion.getInstance();

    public boolean add(Categorie c)
    {
        try
        {
            String req = "INSERT INTO categorie(`categorieName`)"
                    + " VALUES ('" + c.getCategorieName() + "');";

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
    
    public Vector<Categorie> findAll()
    {
        String req = "SELECT* " + " FROM categorie ";

        Vector <Categorie> vect = null;

        try
        {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next())
            {

                if (vect == null)
                {
                    vect = new Vector<Categorie>();
                }

                Categorie e = new Categorie(rs.getInt(1), rs.getString(2));

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
