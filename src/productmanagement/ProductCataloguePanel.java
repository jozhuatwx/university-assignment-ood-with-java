package productmanagement;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ProductCataloguePanel extends javax.swing.JPanel {
    MainForm main;

    public ProductCataloguePanel(MainForm main) {
        initComponents();
        this.main = main;
        // Hide the Add button for Administrator
        if (Administrator.isAdministrator()) {
            btnAdd.setVisible(false);
        }
        // Populate the list with Product Catalogues
        repopulateCatalogueList();
    }

    public void repopulateCatalogueList() {
        // Remove all existing Product Catalogues
        pnlCatalogueList.removeAll();

        int i = 0;
        ArrayList<String> catalogueArray = ReadObject.readArray(ProductCatalogue.FILE_NAME);
        // Iterate through the Product Catalogue array
        for (; i < catalogueArray.size(); i++) {
            // Split the line into an array
            String[] details = catalogueArray.get(i).split(";");
            // Create a Product Catalogue object with the details
            ProductCatalogue catalogue = new ProductCatalogue(details);
            // Create a Universal Panel object with the Product Catalogue object
            ProductCatalogueUniversalPanel pcup = new ProductCatalogueUniversalPanel(main, this, catalogue, i + 1);
            // Set the size of the Universal Panel
            pcup.setPreferredSize(new Dimension(ProductCatalogueUniversalPanel.MAIN_WIDTH, ProductCatalogueUniversalPanel.MAIN_MIN_HEIGHT));
            // Add the Panel into the list
            pnlCatalogueList.add(pcup);
        }
        // Fill remaining space with an empty box
        if (i * ProductCatalogueUniversalPanel.MAIN_MIN_HEIGHT < 385) {
            pnlCatalogueList.add(Box.createRigidArea(new Dimension(0, 385 - (ProductCatalogueUniversalPanel.MAIN_MIN_HEIGHT * i))));
        }
        pnlCatalogueList.revalidate();
    }

    private void search() {
        String keyword = txtSearch.getText().trim();

        // Remove all existing Product Catalogues
        pnlCatalogueList.removeAll();

        int i = 0;
        ArrayList<ProductCatalogue> catalogueArray = ProductCatalogue.search(keyword);
        // Iterate through the Product Catalogue array
        for (; i < catalogueArray.size(); i++) {
            // Create a Universal Panel object with the Product Catalogue object
            ProductCatalogueUniversalPanel pcup = new ProductCatalogueUniversalPanel(main, this, catalogueArray.get(i), i + 1);
            // Set the size of the Universal Panel
            pcup.setPreferredSize(new Dimension(ProductCatalogueUniversalPanel.MAIN_WIDTH, ProductCatalogueUniversalPanel.MAIN_MIN_HEIGHT));
            // Add the Panel into the list
            pnlCatalogueList.add(pcup);
        }
        // Fill remaining space with an empty box
        if (i * ProductCatalogueUniversalPanel.MAIN_MIN_HEIGHT < 385) {
            pnlCatalogueList.add(Box.createRigidArea(new Dimension(0, 385 - (ProductCatalogueUniversalPanel.MAIN_MIN_HEIGHT * i))));
        }
        pnlCatalogueList.revalidate();
        pnlCatalogueList.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlAddItem = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        scrCatalogueList = new javax.swing.JScrollPane();
        pnlCatalogueList = new javax.swing.JPanel();

        setBackground(new java.awt.Color(18, 22, 31));

        pnlAddItem.setBackground(new java.awt.Color(46, 52, 66));
        pnlAddItem.setMaximumSize(new java.awt.Dimension(755, 32767));
        pnlAddItem.setPreferredSize(new java.awt.Dimension(755, 61));

        txtSearch.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        txtSearch.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSearch.setText("Search");
        txtSearch.setBorder(null);
        txtSearch.setPreferredSize(new java.awt.Dimension(407, 40));
        txtSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSearchFocusLost(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(46, 52, 66));
        btnAdd.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/productmanagement/img/add.png"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd.setPreferredSize(new java.awt.Dimension(150, 40));
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlAddItemLayout = new javax.swing.GroupLayout(pnlAddItem);
        pnlAddItem.setLayout(pnlAddItemLayout);
        pnlAddItemLayout.setHorizontalGroup(
            pnlAddItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAddItemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlAddItemLayout.setVerticalGroup(
            pnlAddItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAddItemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAddItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAddItemLayout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        scrCatalogueList.setBackground(new java.awt.Color(46, 52, 66));
        scrCatalogueList.setBorder(null);
        scrCatalogueList.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrCatalogueList.setToolTipText("");
        scrCatalogueList.setPreferredSize(new java.awt.Dimension(755, 385));
        scrCatalogueList.getVerticalScrollBar().setUnitIncrement(16);

        pnlCatalogueList.setBackground(new java.awt.Color(46, 52, 66));
        pnlCatalogueList.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        pnlCatalogueList.setLayout(new javax.swing.BoxLayout(pnlCatalogueList, javax.swing.BoxLayout.Y_AXIS));
        scrCatalogueList.setViewportView(pnlCatalogueList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlAddItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrCatalogueList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlAddItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrCatalogueList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
        if (!main.isEditing) {
            ProductCatalogueForm pcf= new ProductCatalogueForm(main, this);
            pcf.setVisible(true);
            main.setVisible(false);
            main.isEditing = true;
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "You have unsaved work. Please save it first.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnAddMouseClicked

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        search();
    }//GEN-LAST:event_txtSearchKeyReleased

    private void txtSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusLost
        if (txtSearch.getText().trim().equalsIgnoreCase("")) {
            txtSearch.setText("Search");
        }
    }//GEN-LAST:event_txtSearchFocusLost

    private void txtSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusGained
        if (txtSearch.getText().trim().equalsIgnoreCase("Search")) {
            txtSearch.setText("");
        }
    }//GEN-LAST:event_txtSearchFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JPanel pnlAddItem;
    private javax.swing.JPanel pnlCatalogueList;
    private javax.swing.JScrollPane scrCatalogueList;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}