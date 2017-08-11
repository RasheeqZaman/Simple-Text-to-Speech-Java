import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 11, 201, 190);
		frame.getContentPane().add(textArea);
		
		Voice voice;
		VoiceManager vm = VoiceManager.getInstance();
		voice = vm.getVoice("kevin16");
		voice.allocate();
		
		JButton btnSpeech = new JButton("Speech");
		btnSpeech.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				voice.speak(textArea.getText());
			}
		});
		btnSpeech.setBounds(268, 54, 89, 23);
		frame.getContentPane().add(btnSpeech);
	}
}
