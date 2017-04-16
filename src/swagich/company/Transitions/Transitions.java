/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swagich.company.Transitions;

import javafx.animation.FadeTransition;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

/**
 *
 * @author Sam
 */
public class Transitions {
    
      public void showNode(final AnchorPane fromRoot ,final AnchorPane toRoot ,final Node node){
        FadeTransition ft = new FadeTransition();
        ft.setAutoReverse(false);
        ft.setDelay(Duration.millis(1500));
        ft.setFromValue(0.1);
        ft.setToValue(1);
        fromRoot.getChildren().clear();
        fromRoot.getChildren().add(toRoot);
        
        
    }
    
}
