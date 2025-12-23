package javaHomework.hw1216;

import java.awt.Color;
import java.awt.Font;
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
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class GridBagLayoutWindows {

    private JFrame jframe;

    private String[] objText;
    private String[] objFile;
    private String[] objComboColor;
    private String[] textSize;

    private Color[][] textStyles;

    private int[][] gbcParameter;

    private ArrayList<JComponent> GUIComponent;

    private JComponent[] jTextFields;

    private JTextField jTF_FilePathway = null;
    private JTextArea jTF_FileInformation = null;
    private JTextArea jTF_FileContent = null;

    private JScrollPane jSP_FileInformation = null;
    private JScrollPane jSP_FileContent = null;
    private JScrollPane jSP_textSize = null;

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

    private JToggleButton[] jFontButtons;
    private JToggleButton jtb_FontBold = null;
    private JToggleButton jtb_FontItalic = null;

    private JList jl_textSize = null;

    private ButtonGroup buttonGroup = new ButtonGroup();
    
    private JComboBox<String> jcob_Foreground = null;
    private JComboBox<String> jcob_Background = null;

    JSlider slider_Text = null;
    JLabel jlbTextSize = null;
    
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
                "解密",
                "文字顏色",
                "底色",
                "文字大小"
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
        textSize = new String[] {
                "8", "12", "24", "36", "48", "64", "80", "90", "100"
        };
        objComboColor = new String[] {
                "黑色",
                "黃色",
                "灰色",
                "綠色",
                "紅色",
                "藍色"
        };

        // gbcParameter: gridx, gridy, gridwidth, gridheight, weightx, weighty, fill,
        // anchor
        gbcParameter = new int[][] {
                {0, 0, 1, 1, 0, 0, NONE, WEST }, // label: 路徑
                {0, 1, 1, 1, 0, 0, NONE, WEST }, // label: 檔案資訊
                {0, 11, 1, 1, 0, 0, BOTH, WEST }, // label: 檔案內容
                {1, 0, 7, 1, 1, 0, BOTH, WEST }, // 路徑的 TextField
                {1, 1, 7, 5, 1, 1, BOTH, WEST }, // 檔案資訊的 TextArea
                {1, 12, 7, 7, 1, 1, BOTH, WEST }, // 檔案內容的 TextArea
                {1, 11, 1, 1, 1, 0, BOTH, CENTER }, // Button 開啟檔案
                {2, 11, 1, 1, 1, 0, BOTH, CENTER }, // Button 讀取內容
                {3, 11, 2, 1, 1, 0, BOTH, CENTER }, // Button 加密
                {5, 11, 3, 1, 1, 0, BOTH, CENTER }, // Button 解密
                {1, 6, 1, 1, 1, 0, BOTH, CENTER }, // CheckBox 檔案長度
                {2, 6, 1, 1, 1, 0, BOTH, CENTER }, // CheckBox 是否為檔案
                {3, 6, 1, 1, 1, 0, BOTH, CENTER }, // CheckBox 是否為目錄
                {5, 6, 1, 1, 1, 0, BOTH, CENTER }, // CheckBox 是否可讀
                {1, 7, 1, 1, 1, 0, BOTH, CENTER }, // CheckBox 是否可寫
                {2, 7, 1, 1, 1, 0, BOTH, CENTER }, // CheckBox 是否隱藏
                {3, 7, 1, 1, 1, 0, BOTH, CENTER }, // CheckBox 最後修改日期
                {5, 7, 1, 1, 1, 0, BOTH, CENTER },  // CheckBox 檔案名稱
                {1, 8, 1, 1, 1, 0, BOTH, CENTER }, // CheckBox 檔案路徑
                {2, 8, 1, 1, 1, 0, BOTH, CENTER },  // CheckBox 絕對路徑
                {3, 8, 1, 1, 1, 0, BOTH, CENTER }, // RadioButton 樣式 1
                {4, 8, 1, 1, 1, 0, BOTH, CENTER }, // RadioButton 樣式 2
                {5, 8, 1, 1, 1, 0, BOTH, CENTER }, // 自訂
                {1, 9, 1, 1, 1, 0, BOTH, CENTER }, // Label 文字顏色
                {2, 9, 1, 1, 1, 0, BOTH, CENTER }, // ComboBox 文字顏色
                {3, 9, 1, 1, 1, 0, BOTH, CENTER }, // Label 底色
                {4, 9, 1, 1, 1, 0, BOTH, CENTER }, // ComboBox 底色
                {1, 10, 1, 1, 1, 0, BOTH, CENTER }, // Label 文字大小
                {2, 10, 3, 1, 1, 0, BOTH, CENTER },  // Slider
                {5, 10, 1, 1, 1, 0, BOTH, CENTER },  // Label textSize
                {6, 10, 1, 1, 1, 0, BOTH, CENTER }, // JToggleButton粗體
                {7, 10, 1, 1, 1, 0, BOTH, CENTER }, // Italic Button斜體
                {6, 6, 2, 4, 1, 0, BOTH, CENTER }  // JList文字大小
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
        doJcomboBox();
        doJToggleButton();
        doButtonActionListener();
        jTextFields = new JComponent[] { jTF_FilePathway, jSP_FileInformation, jSP_FileContent };
        jButtonActionListener = new ActionListener[] { openFile, roadFileText, encode, decode };
        GUIComponent = new ArrayList<JComponent>();
    }

    
    public void run() {
        jframe.setSize(800, 600);
        jframe.setLayout(new GridBagLayout());
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for (int i = 0; i < 3; i++) {
            JLabel jlabel = new JLabel(objText[i]);
            GUIComponent.add(jlabel);
        }

        for (int i = 0; i < jTextFields.length; i++) {
            GUIComponent.add(jTextFields[i]);
        }

        for (int i = 3; i <= 6; i++) {
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
                    jcob_Background.setEnabled(false);
                    jcob_Foreground.setEnabled(false);
                }
                
            });
            buttonGroup.add(jrb);
            GUIComponent.add(jrb);
        }

        JRadioButton jrb_UserSetting = new JRadioButton("自訂");
        jrb_UserSetting.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jcob_Background.setEnabled(true);
                jcob_Foreground.setEnabled(true);
            }
        });
        buttonGroup.add(jrb_UserSetting);
        GUIComponent.add(jrb_UserSetting);

        JLabel jlabel_Foreground = new JLabel(objText[7]);  // 文字顏色
        GUIComponent.add(jlabel_Foreground);
        GUIComponent.add(jcob_Foreground);

        JLabel jlabel_Background = new JLabel(objText[8]);  // 底色
        GUIComponent.add(jlabel_Background);
        GUIComponent.add(jcob_Background);

        JLabel jlabel_SliderText = new JLabel(objText[9]); // 文字大小
        GUIComponent.add(jlabel_SliderText);

        slider_Text = new JSlider(JSlider.HORIZONTAL, 0, 100, 12);
        slider_Text.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                Font font = jTF_FileInformation.getFont().deriveFont((float)slider_Text.getValue());
                jTF_FileInformation.setFont(font);
                jTF_FileContent.setFont(font);
                jlbTextSize.setText(String.valueOf(slider_Text.getValue()));
            }
        });

        GUIComponent.add(slider_Text);

        jlbTextSize = new JLabel(String.valueOf(slider_Text.getValue()));
        GUIComponent.add(jlbTextSize);

        for (int i = 0; i < jFontButtons.length; i++) {
            GUIComponent.add(jFontButtons[i]);
        }

        jl_textSize = new JList();
        jl_textSize.setListData(textSize);
        jl_textSize.setSelectedIndex(1);
        jl_textSize.setVisibleRowCount(5);
        jl_textSize.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                Font font = jTF_FileInformation.getFont().deriveFont(
                    Float.valueOf((String)jl_textSize.getSelectedValue().toString()));
                jTF_FileInformation.setFont(font);
                jTF_FileContent.setFont(font);
                jlbTextSize.setText(jl_textSize.getSelectedValue().toString());
                slider_Text.setValue(Integer.valueOf(jl_textSize.getSelectedValue().toString()));
            }
            
        });
        jSP_textSize = new JScrollPane(jl_textSize);
        GUIComponent.add(jSP_textSize);


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

    private void doJcomboBox() {
        jcob_Foreground = new JComboBox<String>();
        jcob_Background = new JComboBox<String>();
        for (int i = 0; i < objComboColor.length; i++) {
            jcob_Foreground.addItem(objComboColor[i]);
            jcob_Background.addItem(objComboColor[i]);
            jcob_Foreground.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String color_Foreground = (String)jcob_Foreground.getSelectedItem();
                    String color_Background = (String)jcob_Background.getSelectedItem();
                    changeTextColor(color_Foreground, color_Background);
                }
            });
            jcob_Background.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String color_Foreground = (String)jcob_Foreground.getSelectedItem();
                    String color_Background = (String)jcob_Background.getSelectedItem();
                    changeTextColor(color_Foreground, color_Background);
                }
            });
            jcob_Foreground.setEnabled(false);
            jcob_Background.setEnabled(false);
        }
    }

    private void changeTextColor(String foreGrund, String backGround) {
        jTF_FileInformation.setBackground(getColor(backGround));
        jTF_FileInformation.setForeground(getColor(foreGrund));
        jTF_FileContent.setBackground(getColor(backGround));
        jTF_FileContent.setForeground(getColor(foreGrund));

    }

    private Color getColor(String color) {
        switch(color) {
            case "黑色":
                return Color.black;
            case "黃色":
                return Color.yellow;
            case "灰色":
                return Color.gray;
            case "綠色":
                return Color.green;
            case "紅色":
                return Color.red;
            case "藍色":
                return Color.blue;
        }
        return null;
    }

    private void doJToggleButton() {
        jtb_FontBold = new JToggleButton("B");
        jtb_FontBold.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Font font = new Font(jTF_FileInformation.getFont().getName(), 
                jTF_FileInformation.getFont().getStyle() ^ Font.BOLD,
                jTF_FileInformation.getFont().getSize());
                jTF_FileInformation.setFont(font);
                jTF_FileContent.setFont(font);
            }

        });
        jtb_FontItalic = new JToggleButton("I");
        jtb_FontItalic.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Font font = new Font(jTF_FileInformation.getFont().getName(), 
                jTF_FileInformation.getFont().getStyle() ^ Font.ITALIC,
                jTF_FileInformation.getFont().getSize());
                jTF_FileInformation.setFont(font);
                jTF_FileContent.setFont(font);
            }

        });
        jFontButtons = new JToggleButton[2];
        jFontButtons[0] = jtb_FontBold;
        jFontButtons[1] = jtb_FontItalic;
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
