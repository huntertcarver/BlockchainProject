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
        Map<String, Integer> nameCounter = new HashMap<String, Integer>();

        // Adding names to the list and counting occurrences
        for (int i = 0; i < blocks.size(); i++) {
            namesList.add(blocks.get(i).getData());
            if (nameCounter.containsKey(blocks.get(i).getData())) {
                int count = nameCounter.get(blocks.get(i).getData());
                nameCounter.put(blocks.get(i).getData(), count + 1);
            } else {
                nameCounter.put(blocks.get(i).getData(), 1);
            }
        }

        // Printing out the list of names and their counts
        for (String name : nameCounter.keySet()) {
            int count = nameCounter.get(name);
            JLabel results = new JLabel(name + ": has " + count + " votes.");
            frame.add(results);
        }
        frame.setVisible(true);
        frame.setSize(450, 450);
	}
}
