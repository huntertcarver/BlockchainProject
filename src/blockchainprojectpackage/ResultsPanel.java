package blockchainprojectpackage;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ResultsPanel extends JFrame {
    private static final long serialVersionUID = 1L;
    Font font = new Font("Verdana", Font.BOLD, 14);

    public ResultsPanel(Blockchain chain) {
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
    	//setLayout(new FlowLayout());
        ArrayList<Block> blocks = chain.getBlocks();

        Map<String, Integer> voteMap = new HashMap<String, Integer>();

        for (int i = 1; i < blocks.size(); i++) {
            //If vote canidate does not exist in map yet add its key.
            if(!voteMap.containsKey(blocks.get(i).getData())) {
                voteMap.put(blocks.get(i).getData(), 1);
                //Else if canidate does exist in the map, add 1 to its current vote.
            }else {
                voteMap.put(blocks.get(i).getData(), voteMap.get(blocks.get(i).getData())+1);
            }
        }

        // Printing out the list of names and their counts
        for (HashMap.Entry<String, Integer> entry : voteMap.entrySet()) {
            JLabel results = new JLabel("  " + entry.getKey() + " has " + entry.getValue() + " votes.\n");
            add(results);
            results.setHorizontalAlignment(JLabel.CENTER);
            results.setForeground(Color.WHITE);
            results.setFont(font);
        }
        
        getContentPane().setBackground(Color.DARK_GRAY);
        setVisible(true);
        setSize(330, 200);
    }
}