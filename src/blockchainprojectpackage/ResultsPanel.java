package blockchainprojectpackage;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultsPanel extends JFrame {
    private static final long serialVersionUID = 1L;
    public JFrame frame = new JFrame();

    public ResultsPanel(Blockchain chain) {
        frame.setLayout(new FlowLayout());
        ArrayList<Block> blocks = chain.getBlocks();

        List<String> namesList = new ArrayList<String>();
        Map<String, Integer> voteMap = new HashMap<String, Integer>();
        int currentVoteCount = 0;


        for (int i = 0; i < blocks.size(); i++) {
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
            JLabel results = new JLabel(entry.getKey() + ": has " + entry.getValue() + " votes.");
            frame.add(results);
        }
        frame.setVisible(true);
        frame.setSize(450, 450);
    }
}