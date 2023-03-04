// package frc.robot.subsystems;
// import edu.wpi.first.wpilibj.TimedRobot;
// import edu.wpi.first.wpilibj.Timer;

// public class Auto{
//     private String auto [][] = {
//       {"Arm High Cube", "None"}
//     };

//     Timer timmy = new Timer();
//     private String name;
//     private int autonomous_counter = 0;
//     private double lil_sam = 0;
//     private String[][] spyroom;

//     public Auto(String name){
//       this.name = name;
//       this.spyroom = auto; // Auto names go here
//     }

//     public void start(){
//       timmy.reset();
//       timmy.start();
//       briefcase(spyroom[0][0]);
//       lil_sam = lil_sam + Double.parseDouble(spyroom[0][2]);
//     }

//     public void check(){
//       if(timmy.get() > lil_sam){
//         briefcase(spyroom[autonomous_counter][1]);
//         autonomous_counter++;
//         briefcase(spyroom[autonomous_counter][0]);
//         lil_sam = lil_sam + Double.parseDouble(spyroom[autonomous_counter][2]);
//       }
//     }


//     private void briefcase(String task){
//       System.out.println(task);
//       switch(task){
//         case "Arm High Cube":
//         System.out.println("High Cube");
//         new ArmCubeHighCommand(arm);
//         break;
//         case "None":
//           System.out.println("Nothing");
//           break;
//       }
//     }

//   } // <-- keep brace
