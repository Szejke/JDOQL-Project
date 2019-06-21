package sample;



import com.sun.xml.internal.ws.util.StringUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.*;

import javax.jdo.*;
import java.util.*;

public class Database {

    PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("proJDO");
    PersistenceManager pm = pmf.getPersistenceManager();
    Transaction tx = pm.currentTransaction();






    public ArrayList<String> tableNameList = new ArrayList<>();




    public void testSelect() {

        try {
            tx.begin();
             Filmy filmy = new Filmy("asd", "123", "asdf" , "oasdfą", "nie wiem", "inż. Rafał Warzyński");
             Status status = new Status("aktywny");
//            String data="01-02-2013";
//            SimpleDateFormat sdf1 = new SimpleDateFormat("dd-mm-yyyy");
//            java.util.Date date = sdf1.parse(data);
//            java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
//
//             Katalog katalog = new Katalog(1,1,1,1, sqlStartDate);
//           // Kategorie kategorie = new Kategorie("akcja");
           //  Role role = new Role("wypz");
            // UprawnieniaUz uprawnieniaUz = new UprawnieniaUz(1,1);
           //  Uzytkownicy uzytkownicy = new Uzytkownicy("rafak","wawa","gmail@gamil.com","123","123","tak");


              // pm.makePersistent(katalog);


            Query q = pm.newQuery("javax.jdo.query.SQL", "SELECT table_name FROM information_schema.tables where table_schema like 'db_netfilm'");
            List<String> products = q.executeList();
            Iterator<String> iter = products.iterator();
            while (iter.hasNext()) {
                String p = iter.next();
                tableNameList.add(p);

            }

            tx.commit();

        } catch (Exception e) {
            System.out.println("Exception persisting data : " + e.getMessage());
        } finally {
            if (tx.isActive()) {
                tx.rollback();
            }
            pm.close();
        }

        pm = pmf.getPersistenceManager();
        tx = pm.currentTransaction();
    }


    ArrayList<String> selectNameColumnt(String nameTable){

        ArrayList<String> nowa = new  ArrayList<>();
        try {
            tx.begin();

            Query q = pm.newQuery("javax.jdo.query.SQL", "SELECT COLUMN_NAME FROM information_schema.columns WHERE table_name='" + nameTable + "'");
            List<String> products = q.executeList();
            Iterator<String> iter = products.iterator();
            while (iter.hasNext()) {

                String p = iter.next();
                nowa.add(p);

            }
            tx.commit();

        } catch (Exception e) {
            System.out.println("nie poszło Select Name column: " + e.getMessage());
        } finally {
            if (tx.isActive()) {
                tx.rollback();
            }
            pm.close();
        }

        pm = pmf.getPersistenceManager();
        tx = pm.currentTransaction();

        return nowa;


    }


    public ArrayList<String> getTableNameList() {
        return tableNameList;
    }




    void addFilmy(String tytulFilmu, String rok, String obrazek, String opis, String usuniecie, String rezyser) {
        try {
            tx.begin();
            Filmy filmy = new Filmy(tytulFilmu, rok, obrazek , opis, usuniecie, rezyser);
                pm.makePersistent(filmy);

            Query q = pm.newQuery("SELECT FROM " + Filmy.class.getName() );
            List<Filmy> products = q.executeList();
            Iterator<Filmy> iter = products.iterator();

            while (iter.hasNext()) {
                Filmy p = iter.next();
                System.out.println(p.getTytulFilmu());

            }
            tx.commit();

        } catch (Exception e) {
            System.out.println("nie dodano: " + e.getMessage());
        } finally {
            if (tx.isActive()) {
                tx.rollback();
            }
            pm.close();
        }

        pm = pmf.getPersistenceManager();
        tx = pm.currentTransaction();

    }



    public void addStatus(String text) {
        {
            try {
                tx.begin();
                Status status = new Status(text);
                pm.makePersistent(status);

                Query q = pm.newQuery("SELECT FROM " + Status.class.getName() );
                List<Status> products = q.executeList();
                Iterator<Status> iter = products.iterator();
                while (iter.hasNext()) {
                    Status p = iter.next();
                    System.out.println(p.getNazwaStatus());
                }
                tx.commit();

            } catch (Exception e) {
                System.out.println("nie dodano: " + e.getMessage());
            } finally {
                if (tx.isActive()) {
                    tx.rollback();
                }
                pm.close();
            }

            pm = pmf.getPersistenceManager();
            tx = pm.currentTransaction();

        }
    }

    ArrayList<String> selectAll(String nametable){
        ArrayList<String> dataDB = new ArrayList();
        String nameTable  = StringUtils.capitalize(nametable);

        if(nameTable.equals("Filmy")) {
            try {
                tx.begin();
                Query q = pm.newQuery("SELECT FROM " + "model." + nameTable);
                List<Filmy> products = q.executeList();
                Iterator<Filmy> iter = products.iterator();
                while (iter.hasNext()) {
                    Filmy p = iter.next();
                    dataDB.add(p.getFilmyId() + " ," + p.getTytulFilmu() + ", " + p.getOpis()+ ", "+ p.getRok() + ", "+ p.getObrazek());
                }
                tx.commit();

            } catch (Exception e) {
                System.out.println("nie dodano: " + e.getMessage());
            } finally {
                if (tx.isActive()) {
                    tx.rollback();
                }
                pm.close();
            }

            pm = pmf.getPersistenceManager();
            tx = pm.currentTransaction();
        }
        return dataDB;
    }

}
