package Implement;

import Interface.NotasInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class NotasImplement extends UnicastRemoteObject implements NotasInterface {
    public int students;
    public int notes;

    public int getStudents() {
        return students;
    }
    public void setStudents(int students) {
        this.students = students;
    }
    public int getNotes() {
        return notes;
    }
    public void setNotes(int notes) {
        this.notes = notes;
    }
    public NotasImplement(int students, int notes) throws RemoteException {
        this.students = students;
        this.notes = notes;
    }
    @Override
    public Map generate(int s, int n) throws RemoteException {
        
        float max, min, suma, total = 0;
        float matriz[][] = new float[s][n];
        Map<String, Float> answer = new HashMap<String, Float>();
        
        for (int i = 0; i < s; i++) {            
            max = 0;
            min = 5;
            suma = 0;            
            for (int j = 0; j < n; j++) {
                matriz[i][j] 
                        = (float)(Math.round(Math.random() * 5 * 10.0) / 10.0); 
                if (matriz[i][j] > max){
                    max = matriz[i][j];
                }
                if (matriz[i][j] < min){
                    min = matriz[i][j];
                }
                suma = suma + matriz[i][j];
            }
            answer.put("Menor nota estudiante " 
                    + String.valueOf(i)
                    , (float) (Math.round(min * 10.0) / 10.0));
            answer.put("Mayor nota estudiante " 
                    + String.valueOf(i)
                    , (float) (Math.round(max * 10.0) / 10.0));
            answer.put("Promedio notas del grupo " 
                    + String.valueOf(i)
                    , (float) (Math.round(suma / n * 10.0) / 10.0));
            total = (float) (Math.round((total + (suma / n)) * 10.0) / 10.0);
        }
        
        answer.put("Promedio total notas "
                , (float) (Math.round(total / s * 10.0) / 10.0));
        
        for (int x = 0; x < matriz.length; x++) {
            System.out.print("|");
            for (int y=0; y < matriz[x].length; y++) {
                System.out.print (matriz[x][y]);
                if (y!=matriz[x].length-1) System.out.print("\t");
            }
            System.out.println("|");
        }        
        return answer;
    }
}