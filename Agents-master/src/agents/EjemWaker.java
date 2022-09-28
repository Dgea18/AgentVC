/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agents;
import jade.core.Agent;
import jade.core.behaviours.WakerBehaviour;
/**
 *
 * @author carlo
 */
public class EjemWaker extends Agent{
    protected void setup()
    {
        System.out.println("Añadir comportamiento Wake");
        addBehaviour (new WakerBehaviour (this, 10000)
                {
                    protected void onWake()
                    {
                        System.out.println("Pasaron 10 segundos");
                    }
                });
    }
}
