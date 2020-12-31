package PageMenu

import java.sql._

import javax.swing.JButton

import javax.swing.JFrame

import javax.swing.table.DefaultTableModel

import PageLogin.connexion

import Professeurs._

object Professeurs {

  /**
    * @param args the command line arguments
    */
  def main(args: Array[String]): Unit = {
    try for (info <- javax.swing.UIManager.getInstalledLookAndFeels
             if "Nimbus" == info.getName) {
      javax.swing.UIManager.setLookAndFeel(info.getClassName)
//break
    } catch {
      case ex: ClassNotFoundException =>
        java.util.logging.Logger
          .getLogger(classOf[Professeurs].getName)
          .log(java.util.logging.Level.SEVERE, null, ex)

      case ex: InstantiationException =>
        java.util.logging.Logger
          .getLogger(classOf[Professeurs].getName)
          .log(java.util.logging.Level.SEVERE, null, ex)

      case ex: IllegalAccessException =>
        java.util.logging.Logger
          .getLogger(classOf[Professeurs].getName)
          .log(java.util.logging.Level.SEVERE, null, ex)

      case ex: javax.swing.UnsupportedLookAndFeelException =>
        java.util.logging.Logger
          .getLogger(classOf[Professeurs].getName)
          .log(java.util.logging.Level.SEVERE, null, ex)

    }
  }
//</editor-fold>
// Create and display the form
  /*  java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	               new listprofesseurs().setVisible(true);
	            }
	        });*/

//</editor-fold>
// Create and display the form
  /*  java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	               new listprofesseurs().setVisible(true);
	            }
	        });*/

}

class Professeurs extends javax.swing.JFrame {

  private var bfer: JButton = new JButton("Fermer")

  private var query: String = "SELECT  * FROM professeurs order by  nom asc"

//public class FenetreListeProduit extends javax.swing.JFrame {
  var stListe: Statement = _

  var maconnexion: connexion = new connexion()

  initComponents()

  this.setLocation(500, 200)

  this.defaultCloseOperation = JFrame.DISPOSE_ON_CLOSE

  val model: DefaultTableModel = new DefaultTableModel()

  model.addColumn("idProfesseur")

  model.addColumn("nomProfesseur")

  model.addColumn("prenomPro")

  model.addColumn("grade")


  TABLEPRO.setModel(model)

  try {
    stListe = maconnexion.etablirconnection().createStatement()
    val resultat: ResultSet = stListe.executeQuery(query)
    while (resultat.next()) model.addRow(
      Array(resultat.getString("idProfesseur"),
            resultat.getString("nomProfesseur"),
            resultat.getString("prenomPro"),
            resultat.getString("grade")))
  } catch {
    case ex: SQLException => println(ex)

  }

  bfer.setBounds(75, 150, 100, 30)

  /**
    * This method is called from within the constructor to initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is always
    * regenerated by the Form Editor.
    */
  private def initComponents(): Unit = {
    jLabel1 = new javax.swing.JLabel()
    TABLE = new javax.swing.JScrollPane()
    TABLEPRO = new javax.swing.JTable()
    this.defaultCloseOperation = javax.swing.WindowConstants.DISPOSE_ON_CLOSE
// NOI18N
    jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14))
    jLabel1.setText("LISTE DES PROFFESSEURS")
    TABLEPRO.setModel(
      new javax.swing.table.DefaultTableModel(
        Array(Array(null, null, null, null, null),
              Array(null, null, null, null, null),
              Array(null, null, null, null, null),
              Array(null, null, null, null, null)),
        Array("Title 1", "Title 2", "Title 3")
      ))
    TABLE.setViewportView(TABLEPRO)
    val layout: javax.swing.GroupLayout =
      new javax.swing.GroupLayout(getContentPane)
    getContentPane.setLayout(layout)
    layout.setHorizontalGroup(
      layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(
          layout
            .createSequentialGroup()
            .addGroup(
              layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(
                  layout
                    .createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(jLabel1,
                                  javax.swing.GroupLayout.PREFERRED_SIZE,
                                  282,
                                  javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(
                  layout
                    .createSequentialGroup()
                    .addContainerGap()
                    .addComponent(TABLE,
                                  javax.swing.GroupLayout.PREFERRED_SIZE,
                                  375,
                                  javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(15, java.lang.Short.MAX_VALUE)))
    layout.setVerticalGroup(
      layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(
          layout
            .createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel1,
                          javax.swing.GroupLayout.PREFERRED_SIZE,
                          29,
                          javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(
              javax.swing.LayoutStyle.ComponentPlacement.RELATED,
              javax.swing.GroupLayout.DEFAULT_SIZE,
              java.lang.Short.MAX_VALUE)
            .addComponent(TABLE,
                          javax.swing.GroupLayout.PREFERRED_SIZE,
                          275,
                          javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap()))
    pack()
  }

// Variables declaration - do not modify
  private var TABLE: javax.swing.JScrollPane = _

  private var TABLEPRO: javax.swing.JTable = _

  private var jLabel1: javax.swing.JLabel = _

}