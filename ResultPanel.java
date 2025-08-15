import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.List;

/**
 * Result Panel to display merit list in a tabular format
 */
public class ResultPanel extends JFrame {
    private JTable resultTable;
    private DefaultTableModel tableModel;
    private List<Detail> students;
    private JLabel summaryLabel;
    
    public ResultPanel(List<Detail> students) {
        this.students = students;
        
        setTitle("Merit List Results - " + students.size() + " Students");
        setSize(1400, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        initializeComponents();
        populateTable();
    }
    
    private void initializeComponents() {
        // Header Panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(46, 204, 113));
        headerPanel.setPreferredSize(new Dimension(1400, 70));
        
        JLabel titleLabel = new JLabel("MHT-CET MERIT LIST");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 26));
        titleLabel.setForeground(Color.WHITE);
        headerPanel.add(titleLabel);
        
        // Summary Panel
        JPanel summaryPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
        summaryPanel.setBackground(new Color(236, 240, 241));
        summaryPanel.setBorder(new EmptyBorder(10, 20, 10, 20));
        
        summaryLabel = new JLabel("Total Students: " + students.size() + " | Showing complete merit list with rankings");
        summaryLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        summaryPanel.add(summaryLabel);
        
        // Table
        String[] columns = {
            "Rank", "EN Number", "Name", "Category", "Gender",
            "SSC %", "HSC %", "HSC PCM %", 
            "MHT-CET Total", "Total %ile",
            "Maths %ile", "Physics %ile", "Chemistry %ile",
            "DOB", "Contact", "Email"
        };
        
        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make table read-only
            }
        };
        
        resultTable = new JTable(tableModel);
        
        // Customize table appearance
        resultTable.setRowHeight(30);
        resultTable.setFont(new Font("Arial", Font.PLAIN, 12));
        resultTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        resultTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        // Set column widths
        int[] columnWidths = {60, 100, 180, 80, 70, 70, 70, 80, 100, 80, 80, 80, 100, 100, 110, 200};
        for (int i = 0; i < columnWidths.length; i++) {
            resultTable.getColumnModel().getColumn(i).setPreferredWidth(columnWidths[i]);
        }
        
        // Customize header
        JTableHeader header = resultTable.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 12));
        header.setBackground(new Color(52, 152, 219));
        header.setForeground(Color.WHITE);
        header.setPreferredSize(new Dimension(header.getWidth(), 35));
        
        // Add zebra striping
        resultTable.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                
                if (!isSelected) {
                    if (row % 2 == 0) {
                        c.setBackground(Color.WHITE);
                    } else {
                        c.setBackground(new Color(236, 240, 241));
                    }
                    
                    // Highlight top 3 ranks with gold, silver, bronze colors
                    if (row == 0) {
                        c.setBackground(new Color(255, 215, 0, 80)); // Gold
                    } else if (row == 1) {
                        c.setBackground(new Color(192, 192, 192, 80)); // Silver
                    } else if (row == 2) {
                        c.setBackground(new Color(205, 127, 50, 80)); // Bronze
                    }
                }
                
                // Center align rank column
                if (column == 0) {
                    setHorizontalAlignment(SwingConstants.CENTER);
                } else {
                    setHorizontalAlignment(SwingConstants.LEFT);
                }
                
                return c;
            }
        });
        
        JScrollPane scrollPane = new JScrollPane(resultTable);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(189, 195, 199), 1));
        
        // Button Panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 15));
        buttonPanel.setBackground(Color.WHITE);
        
        JButton exportButton = new JButton("Export to CSV");
        exportButton.setFont(new Font("Arial", Font.BOLD, 14));
        exportButton.setBackground(new Color(52, 152, 219));
        exportButton.setForeground(Color.WHITE);
        exportButton.setFocusPainted(false);
        exportButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        exportButton.addActionListener(e -> exportResults());
        
        JButton printButton = new JButton("Print Results");
        printButton.setFont(new Font("Arial", Font.BOLD, 14));
        printButton.setBackground(new Color(155, 89, 182));
        printButton.setForeground(Color.WHITE);
        printButton.setFocusPainted(false);
        printButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        printButton.addActionListener(e -> printResults());
        
        JButton statsButton = new JButton("View Statistics");
        statsButton.setFont(new Font("Arial", Font.BOLD, 14));
        statsButton.setBackground(new Color(241, 196, 15));
        statsButton.setForeground(Color.WHITE);
        statsButton.setFocusPainted(false);
        statsButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        statsButton.addActionListener(e -> showStatistics());
        
        JButton closeButton = new JButton("Close");
        closeButton.setFont(new Font("Arial", Font.PLAIN, 14));
        closeButton.setBackground(new Color(231, 76, 60));
        closeButton.setForeground(Color.WHITE);
        closeButton.setFocusPainted(false);
        closeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        closeButton.addActionListener(e -> dispose());
        
        buttonPanel.add(exportButton);
        buttonPanel.add(printButton);
        buttonPanel.add(statsButton);
        buttonPanel.add(closeButton);
        
        // Layout
        setLayout(new BorderLayout());
        add(headerPanel, BorderLayout.NORTH);
        
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(summaryPanel, BorderLayout.NORTH);
        centerPanel.add(scrollPane, BorderLayout.CENTER);
        add(centerPanel, BorderLayout.CENTER);
        
        add(buttonPanel, BorderLayout.SOUTH);
    }
    
    private void populateTable() {
        tableModel.setRowCount(0); // Clear existing data
        
        for (Detail student : students) {
            Object[] row = {
                student.getRank(),
                "EN" + student.getEN(),
                student.getName(),
                student.getCategory(),
                student.getGender(),
                String.format("%.2f", student.getSsc_per()),
                String.format("%.2f", student.getHsc_per()),
                String.format("%.2f", student.getHsc_pcm_per()),
                String.format("%.2f", student.getMhtcet().getTotal()),
                String.format("%.2f", student.getPer().getTotal()),
                String.format("%.2f", student.getPer().getMaths()),
                String.format("%.2f", student.getPer().getPhysics()),
                String.format("%.2f", student.getPer().getChemistry()),
                String.format("%02d/%02d/%d", student.getDob().getDay(), 
                    student.getDob().getMonth(), student.getDob().getYear()),
                String.valueOf(student.getPh()),
                student.getEmail()
            };
            tableModel.addRow(row);
        }
    }
    
    private void exportResults() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Export Merit List to CSV");
        fileChooser.setSelectedFile(new File("merit_list_results.csv"));
        
        int result = fileChooser.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File exportFile = fileChooser.getSelectedFile();
            
            // Ensure .csv extension
            if (!exportFile.getName().toLowerCase().endsWith(".csv")) {
                exportFile = new File(exportFile.getAbsolutePath() + ".csv");
            }
            
            try {
                CSVParser.exportResultsToCSV(students, exportFile);
                JOptionPane.showMessageDialog(this,
                    "Merit list exported successfully!\n" + exportFile.getAbsolutePath(),
                    "Export Successful",
                    JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,
                    "Error exporting results: " + e.getMessage(),
                    "Export Error",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void printResults() {
        try {
            boolean complete = resultTable.print(JTable.PrintMode.FIT_WIDTH,
                new java.text.MessageFormat("MHT-CET Merit List"),
                new java.text.MessageFormat("Page {0}"));
            
            if (complete) {
                JOptionPane.showMessageDialog(this,
                    "Print job completed successfully!",
                    "Print Successful",
                    JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (java.awt.print.PrinterException e) {
            JOptionPane.showMessageDialog(this,
                "Error printing: " + e.getMessage(),
                "Print Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void showStatistics() {
        // Calculate statistics
        double avgSSC = 0, avgHSC = 0, avgMHTCET = 0;
        int openCount = 0, scCount = 0, stCount = 0, obcCount = 0, sbcCount = 0;
        int maleCount = 0, femaleCount = 0, otherCount = 0;
        double maxMHTCET = 0, minMHTCET = Double.MAX_VALUE;
        
        for (Detail student : students) {
            avgSSC += student.getSsc_per();
            avgHSC += student.getHsc_per();
            avgMHTCET += student.getMhtcet().getTotal();
            
            // Category count
            switch (student.getCategory()) {
                case "Open": openCount++; break;
                case "SC": scCount++; break;
                case "ST": stCount++; break;
                case "OBC": obcCount++; break;
                case "SBC": sbcCount++; break;
            }
            
            // Gender count
            switch (student.getGender()) {
                case "Male": maleCount++; break;
                case "Female": femaleCount++; break;
                default: otherCount++; break;
            }
            
            // MHT-CET range
            if (student.getMhtcet().getTotal() > maxMHTCET) {
                maxMHTCET = student.getMhtcet().getTotal();
            }
            if (student.getMhtcet().getTotal() < minMHTCET) {
                minMHTCET = student.getMhtcet().getTotal();
            }
        }
        
        int total = students.size();
        avgSSC /= total;
        avgHSC /= total;
        avgMHTCET /= total;
        
        String stats = String.format(
            "<html><body style='width: 400px; padding: 10px;'>" +
            "<h2 style='color: #2980b9;'>Merit List Statistics</h2>" +
            "<hr>" +
            "<h3>Academic Performance:</h3>" +
            "<ul>" +
            "<li><b>Average SSC Percentage:</b> %.2f%%</li>" +
            "<li><b>Average HSC Percentage:</b> %.2f%%</li>" +
            "<li><b>Average MHT-CET Score:</b> %.2f</li>" +
            "<li><b>Highest MHT-CET Score:</b> %.2f</li>" +
            "<li><b>Lowest MHT-CET Score:</b> %.2f</li>" +
            "</ul>" +
            "<h3>Category Distribution:</h3>" +
            "<ul>" +
            "<li><b>Open:</b> %d (%.1f%%)</li>" +
            "<li><b>SC:</b> %d (%.1f%%)</li>" +
            "<li><b>ST:</b> %d (%.1f%%)</li>" +
            "<li><b>OBC:</b> %d (%.1f%%)</li>" +
            "<li><b>SBC:</b> %d (%.1f%%)</li>" +
            "</ul>" +
            "<h3>Gender Distribution:</h3>" +
            "<ul>" +
            "<li><b>Male:</b> %d (%.1f%%)</li>" +
            "<li><b>Female:</b> %d (%.1f%%)</li>" +
            "<li><b>Other:</b> %d (%.1f%%)</li>" +
            "</ul>" +
            "</body></html>",
            avgSSC, avgHSC, avgMHTCET, maxMHTCET, minMHTCET,
            openCount, (openCount * 100.0 / total),
            scCount, (scCount * 100.0 / total),
            stCount, (stCount * 100.0 / total),
            obcCount, (obcCount * 100.0 / total),
            sbcCount, (sbcCount * 100.0 / total),
            maleCount, (maleCount * 100.0 / total),
            femaleCount, (femaleCount * 100.0 / total),
            otherCount, (otherCount * 100.0 / total)
        );
        
        JOptionPane.showMessageDialog(this,
            stats,
            "Statistics",
            JOptionPane.INFORMATION_MESSAGE);
    }
}
