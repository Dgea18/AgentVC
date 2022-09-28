/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agents;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
/**
 *
 * @author carlo
 */
public class AgenteB extends Agent{
    protected void setup()
    {
        this.addBehaviour(new Behaviour()
        {
            public void action()
            {
              System.out.println("Hola Mundo de Agentes, yo soy el agente -->  " +
                getAID().getName());
            }
            public boolean done()
            {
                return true;
            }
        });
    }
}
