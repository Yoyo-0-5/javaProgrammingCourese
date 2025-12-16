package javaHomework.hw1202;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class GridBagLayoutWindows {

    private JFrame jframe;

    private String[] objText;
    private String[] objFile; //for checkbox

    private Color[][] textStyles;

    private int[][] gbcParameter;

    private ArrayList<JComponent> GUIComponent;

    private JComponent[] jTextFields;

    private JTextField jTF_FilePathway = null;
    private JTextArea jTF_FileInformation = null;
    private JTextArea jTF_FileContent = null;

    private JScrollPane jSP_FileInformation = null;
    private JScrollPane jSP_FileContent = null;

    private JCheckBox[] jCheckBoxs;
    private JCheckBox jcb_FileLength = null;
    private JCheckBox jcb_isFile = null;
    private JCheckBox jcb_isDirectory = null;
    private JCheckBox jcb_canRead = null;
    private JCheckBox jcb_canWrite = null;
    private JCheckBox jcb_isHidden = null;
    private JCheckBox jcb_lastModified = null;
    private JCheckBox jcb_getName = null;
    private JCheckBox jcb_getPath = null;
    private JCheckBox jcb_getAbsolutePath = null;

    private ButtonGroup buttonGroup = new ButtonGroup();

    private ActionListener[] jButtonActionListener;
    private ActionListener openFile = null;
    private ActionListener roadFileText = null;
    private ActionListener encode = null;
    private ActionListener decode = null;

    final int BOTH = GridBagConstraints.BOTH;
    final int VERTICAL = GridBagConstraints.VERTICAL;
    final int HORIZONTAL = GridBagConstraints.HORIZONTAL;
    final int NONE = GridBagConstraints.NONE;
    final int CENTER = GridBagConstraints.CENTER;
    final int EAST = GridBagConstraints.EAST;
    final int SOUTHEAST = GridBagConstraints.SOUTHEAST;
    final int SOUTH = GridBagConstraints.SOUTH;
    final int SOUTHWEST = GridBagConstraints.SOUTHWEST;
    final int WEST = GridBagConstraints.WEST;
    final int NORTHWEST = GridBagConstraints.NORTHWEST;
    final int NORTH = GridBagConstraints.NORTH;
    final int NORTHEAST = GridBagConstraints.NORTHEAST;

    public GridBagLayoutWindows() {

        jframe = new JFrame();

        objText = new String[] {
                "路徑",
                "檔案資訊",
                "檔案內容",
                "開啟檔案",
                "讀取內容",
                "加密",
                "解密"
        };

        objFile =  new String[] {
                "檔案長度",
                "是否為檔案",
                "是否為目錄",
                "是否可讀",
                "是否可寫",
                "是否隱藏",
                "最後修改日期",
                "檔案名稱",
                "檔案路徑",
                "絕對路徑"
        };

        textStyles = new Color[][] {
                { Color.white, Color.black },
                { Color.black, Color.yellow },
        };

        // gbcParameter: gridx, gridy, gridwidth, gridheight, weightx, weighty, fill,
        // anchor
        gbcParameter = new int[][] {
                { 0, 0, 1, 1, 0, 0, NONE, WEST }, // label: 路徑
                { 0, 1, 1, 1, 0, 0, NONE, WEST }, // label: 檔案資訊
                { 0, 10, 1, 1, 0, 0, BOTH, WEST }, // label: 檔案內容
                { 1, 0, 4, 1, 1, 0, BOTH, WEST }, // 路徑的 TextField
                { 1, 1, 4, 5, 1, 1, BOTH, WEST }, // 檔案資訊的 TextArea
                { 1, 10, 4, 7, 1, 1, BOTH, WEST }, // 檔案內容的 TextArea
                { 1, 9, 1, 1, 1, 0, BOTH, CENTER }, // Button 開啟檔案
                { 2, 9, 1, 1, 1, 0, BOTH, CENTER }, // Button 讀取內容
                { 3, 9, 1, 1, 1, 0, BOTH, CENTER }, // Button 加密
                { 4, 9, 1, 1, 1, 0, BOTH, CENTER }, // Button 解密
                {1, 6, 1, 1, 1, 0, BOTH, CENTER }, // CheckBox 檔案長度
                {2, 6, 1, 1, 1, 0, BOTH, CENTER }, // CheckBox 是否為檔案
                {3, 6, 1, 1, 1, 0, BOTH, CENTER }, // CheckBox 是否為目錄
                {4, 6, 1, 1, 1, 0, BOTH, CENTER }, // CheckBox 是否可讀
                {1, 7, 1, 1, 1, 0, BOTH, CENTER }, // CheckBox 是否可寫
                {2, 7, 1, 1, 1, 0, BOTH, CENTER }, // CheckBox 是否隱藏
                {3, 7, 1, 1, 1, 0, BOTH, CENTER }, // CheckBox 最後修改日期
                {4, 7, 1, 1, 1, 0, BOTH, CENTER },  // CheckBox 檔案名稱
                {1, 8, 1, 1, 1, 0, BOTH, CENTER }, // CheckBox 檔案路徑
                {2, 8, 1, 1, 1, 0, BOTH, CENTER },  // CheckBox 絕對路徑
                {3, 8, 1, 1, 1, 0, BOTH, CENTER }, // RadioButton 樣式 1
                {4, 8, 1, 1, 1, 0, BOTH, CENTER } // RadioButton 樣式 2
        };
        dojTextFields();
        jCheckBoxs = new JCheckBox[] {
                jcb_FileLength,
                jcb_isFile,
                jcb_isDirectory,
                jcb_canRead,
                jcb_canWrite,
                jcb_isHidden,
                jcb_lastModified,
                jcb_getName,
                jcb_getPath,
                jcb_getAbsolutePath
        };
        doCheckBox();
        doButtonActionListener();
        jTextFields = new JComponent[] { jTF_FilePathway, jSP_FileInformation, jSP_FileContent };
        jButtonActionListener = new ActionListener[] { openFile, roadFileText, encode, decode };
        GUIComponent = new ArrayList<JComponent>();
    }

    public void run() {
        jframe.setSize(800, 300);
        jframe.setLayout(new GridBagLayout());
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for (int i = 0; i < 3; i++) {
            JLabel jlabel = new JLabel(objText[i]);
            GUIComponent.add(jlabel);
        }

        for (int i = 0; i < jTextFields.length; i++) {
            GUIComponent.add(jTextFields[i]);
        }

        for (int i = 3; i < objText.length; i++) {
            JButton jbutton = new JButton(objText[i]);
            jbutton.addActionListener(jButtonActionListener[i - 3]);
            GUIComponent.add(jbutton);
        }

        for(int i = 0; i < jCheckBoxs.length; i++) {
            GUIComponent.add(jCheckBoxs[i]);

        }

        for (int i = 0; i < textStyles.length; i++) {
            JRadioButton jrb = new JRadioButton("樣式" + (i + 1));
            if (i == 0) {
                jrb.setSelected(true);
            }
            jrb.setActionCommand(String.valueOf(i));
            jrb.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    jTF_FileInformation.setBackground(textStyles[Integer.valueOf(jrb.getActionCommand())][0]);
                    jTF_FileInformation.setForeground(textStyles[Integer.valueOf(jrb.getActionCommand())][1]);
                    jTF_FileContent.setBackground(textStyles[Integer.valueOf(jrb.getActionCommand())][0]);
                    jTF_FileContent.setForeground(textStyles[Integer.valueOf(jrb.getActionCommand())][1]);
                }
                
            });
            buttonGroup.add(jrb);
            GUIComponent.add(jrb);
        }

        for (int i = 0; i < GUIComponent.size(); i++) {
            addComponent(i);
        }

        jframe.setVisible(true);
    }

    public void dojTextFields() {
        jTF_FilePathway = new JTextField("", 24);
        jTF_FileInformation = new JTextArea("");
        jTF_FileContent = new JTextArea("");
        jSP_FileInformation = new JScrollPane(jTF_FileInformation);
        jSP_FileContent = new JScrollPane(jTF_FileContent);
    }

    private void doCheckBox() {
        for (int i = 0; i < jCheckBoxs.length; i++) {
            jCheckBoxs[i] = new JCheckBox(objFile[i], true);
            jCheckBoxs[i].addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    roadFile();
                }
            });
        }
    }

    public void doButtonActionListener() {
        openFile = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("openFile");
                JFileChooser fc = new JFileChooser();
                int returnVal = fc.showOpenDialog(jframe);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = fc.getSelectedFile();
                    jTF_FilePathway.setText(file.getAbsolutePath());
                } 
                else {
                    jTF_FilePathway.setText("Open command cancelled by user.");
                }
            }
        };
        roadFileText = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("roadFileText");
                roadFile();
                jTF_FileContent.setText(roadData(jTF_FilePathway.getText()).toString());
            }
        };
        encode = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("encode");
            }
        };
        decode = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("decode");
            }
        };
    }

    private void addComponent(int i) {
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = gbcParameter[i][0];
        c.gridy = gbcParameter[i][1];
        c.gridwidth = gbcParameter[i][2];
        c.gridheight = gbcParameter[i][3];
        c.weightx = gbcParameter[i][4];
        c.weighty = gbcParameter[i][5];
        c.fill = gbcParameter[i][6];
        c.anchor = gbcParameter[i][7];
        jframe.add(GUIComponent.get(i), c);
    }

    private void roadFile() {
        File f = new File(jTF_FilePathway.getText());
        StringBuilder sb = new StringBuilder();
        sb.append(f.getName() + "檔案資訊如下\n");
        sb.append("==========================\n");
        if (jCheckBoxs[0].isSelected()) {   //檔案長度
            sb.append(objFile[0] + f.length() + " bytes\n");
        }
        if (jCheckBoxs[1].isSelected()) {   //是否為檔案
            sb.append(objFile[1] + (f.isFile() ? "是" : "否") + "\n");
        }
        if (jCheckBoxs[2].isSelected()) {   //是否為目錄
            sb.append(objFile[2] + (f.isDirectory() ? "是" : "否") + "\n");
        }
        if (jCheckBoxs[3].isSelected()) {   //是否可讀
            sb.append(objFile[3] + (f.canRead() ? "可讀" : "不可讀") + "\n");
        }
        if (jCheckBoxs[4].isSelected()) {   //是否可寫
            sb.append(objFile[4] + (f.canWrite() ? "可寫" : "不可寫") + "\n");
        }
        if (jCheckBoxs[5].isSelected()) {   //是否隱藏
            sb.append(objFile[5] + (f.isHidden() ? "是" : "否") + "\n");
        }
        if (jCheckBoxs[6].isSelected()) {   //最後修改日期
            sb.append(objFile[6] + new Date(f.lastModified()) + "\n");
        }
        if (jCheckBoxs[7].isSelected()) {   //檔案名稱
            sb.append(objFile[7] + f.getName() + "\n");
        }
        if (jCheckBoxs[8].isSelected()) {   //檔案路徑
            sb.append(objFile[8] + f.getPath() + "\n");
        }
        if (jCheckBoxs[9].isSelected()) {   //絕對路徑
            sb.append(objFile[9] + f.getAbsolutePath() + "\n");
        }
        jTF_FileInformation.setText(sb.toString());
    }

    private StringBuffer roadData(String pathway) {
        StringBuffer sb = new StringBuffer();
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(pathway)));
            String text = "";
            while((text = br.readLine()) != null) {
                sb.append(text + "\n");
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb;
    }

    public static void main(String[] args) {
        new GridBagLayoutWindows().run();
    }
}
