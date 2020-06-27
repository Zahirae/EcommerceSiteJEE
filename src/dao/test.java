package dao;

import Beans.Client;

public class test {

	public static void main(String[] args) {
		ArticleDao dao = new ArticleDao();
        ClientDao daoC = new ClientDao();
        
        for (Client client : daoC.findAll())
        {
            System.out.println(client.getNom());
        }
        
        System.out.println(dao.findByID(1));
        
        System.out.println("#END#");

	}

}
