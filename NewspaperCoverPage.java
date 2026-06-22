import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class NewspaperCoverPage {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(NewspaperCoverPage::createUI);
    }

    private static void createUI() {
        JFrame frame = new JFrame("Daily Times - Newspaper Cover Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 700);
        frame.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout(15, 15));
        mainPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        mainPanel.setBackground(Color.WHITE);

        // ================= HEADER =================
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(Color.WHITE);

        JLabel newspaperTitle = new JLabel("THE DAILY TIMES", SwingConstants.CENTER);
        newspaperTitle.setFont(new Font("Serif", Font.BOLD, 42));

        JLabel dateLabel = new JLabel("Wednesday | May 27, 2026", SwingConstants.LEFT);
        dateLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));

        JLabel priceLabel = new JLabel("Price: $2", SwingConstants.RIGHT);
        priceLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));

        headerPanel.add(dateLabel, BorderLayout.WEST);
        headerPanel.add(newspaperTitle, BorderLayout.CENTER);
        headerPanel.add(priceLabel, BorderLayout.EAST);

        // ================= MAIN CONTENT =================
        JPanel contentPanel = new JPanel(new GridLayout(1, 2, 15, 15));
        contentPanel.setBackground(Color.WHITE);

        // -------- LEFT SIDE --------
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBackground(Color.WHITE);

        JLabel headline = new JLabel("AI Revolution Changes the Future");
        headline.setFont(new Font("Serif", Font.BOLD, 30));
        headline.setAlignmentX(Component.LEFT_ALIGNMENT);

        JTextArea mainArticle = new JTextArea(
                "Artificial Intelligence continues to reshape industries around the world. " +
                "Experts believe the next decade will bring even more advanced systems, " +
                "changing education, healthcare, and technology forever.\n\n" +
                "Developers and students are rapidly adapting to the modern AI-driven world."
        );

        mainArticle.setLineWrap(true);
        mainArticle.setWrapStyleWord(true);
        mainArticle.setEditable(false);
        mainArticle.setFont(new Font("SansSerif", Font.PLAIN, 16));
        mainArticle.setBackground(Color.WHITE);
        mainArticle.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPanel imagePlaceholder = new JPanel();
        imagePlaceholder.setPreferredSize(new Dimension(400, 250));
        imagePlaceholder.setMaximumSize(new Dimension(Integer.MAX_VALUE, 250));
        imagePlaceholder.setBackground(new Color(220, 220, 220));
        imagePlaceholder.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel imageText = new JLabel("Front Page Image");
        imageText.setFont(new Font("SansSerif", Font.BOLD, 18));
        imagePlaceholder.add(imageText);

        leftPanel.add(headline);
        leftPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        leftPanel.add(imagePlaceholder);
        leftPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        leftPanel.add(mainArticle);

        // -------- RIGHT SIDE --------
        JPanel rightPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        rightPanel.setBackground(Color.WHITE);

        rightPanel.add(createNewsCard(
                "Sports",
                "National team secures a dramatic victory in the finals after extra time excitement."
        ));

        rightPanel.add(createNewsCard(
                "Technology",
                "New smartphones with AI-powered chips are expected to dominate the market this year."
        ));

        rightPanel.add(createNewsCard(
                "World",
                "Global leaders meet to discuss climate change and future sustainability goals."
        ));

        contentPanel.add(leftPanel);
        contentPanel.add(rightPanel);

        // ================= FOOTER =================
        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(Color.BLACK);

        JLabel footerText = new JLabel("www.dailytimes.com | Contact: info@dailytimes.com");
        footerText.setForeground(Color.WHITE);
        footerText.setFont(new Font("SansSerif", Font.PLAIN, 14));

        footerPanel.add(footerText);

        // ================= ADD TO FRAME =================
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(contentPanel, BorderLayout.CENTER);
        mainPanel.add(footerPanel, BorderLayout.SOUTH);

        frame.setContentPane(mainPanel);
        frame.setVisible(true);
    }

    private static JPanel createNewsCard(String title, String content) {
        JPanel card = new JPanel(new BorderLayout(10, 10));
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK),
                new EmptyBorder(10, 10, 10, 10)
        ));
        card.setBackground(Color.WHITE);

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 22));

        JTextArea contentArea = new JTextArea(content);
        contentArea.setEditable(false);
        contentArea.setLineWrap(true);
        contentArea.setWrapStyleWord(true);
        contentArea.setFont(new Font("SansSerif", Font.PLAIN, 15));
        contentArea.setBackground(Color.WHITE);

        card.add(titleLabel, BorderLayout.NORTH);
        card.add(contentArea, BorderLayout.CENTER);

        return card;
    }
}
