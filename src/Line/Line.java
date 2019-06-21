package Line;

import Shape.Port;

import java.awt.*;

public abstract class Line {
    protected Port Start;
    protected Port End;

    public Line(Port start, Port end){
        Start = start;
        End = end;
    }
    protected int[][] getRegularPolygon(int x1, int y1, int x2, int y2, int corner_num){
        int dimension = 2;
        double SideLength = 20;


        int[][] CornerPoints = new int[dimension][corner_num];
        double[] rotated_vector;
        double internal_angle = ((corner_num - 2) * 180 ) / corner_num;
        double rotate_angle = 180 - internal_angle;

        double norm = Math.sqrt((x2-x1) * (x2-x1) + (y2-y1) * (y2-y1));
        double[] basic_vector = {(((x1-x2) / norm)*SideLength), (((y1-y2) / norm)*SideLength) };
        //basic_vector = unit_vector * SideLength

        CornerPoints[0][0] = x2;
        CornerPoints[1][0] = y2;

        rotated_vector = RotatedVector(-(internal_angle/2), basic_vector);
        CornerPoints[0][1] = (int)rotated_vector[0] + CornerPoints[0][0];
        CornerPoints[1][1] = (int)rotated_vector[1] + CornerPoints[1][0];

        for (int num=2; num<corner_num; num++){
            rotated_vector = RotatedVector(rotate_angle, rotated_vector);
            CornerPoints[0][num] = (int)rotated_vector[0] + CornerPoints[0][num-1];
            CornerPoints[1][num] = (int)rotated_vector[1] + CornerPoints[1][num-1];
        }
        return CornerPoints;
    }
    protected double[] MatrixOperation2D(double[][] matrix, double[] v){
        int dimension = 2;
        double[] result = new double[dimension];
        for (int i=0 ; i < dimension ; i++){
            result[i] = 0; //Initialize to zero
            for (int j=0 ; j < dimension ; j++){
                result[i] += matrix[i][j] * v[j];
            }
        }
        return result;
    }
    protected double[][] getRotationMatrix2D(double theata){
        double radians = Math.toRadians(theata);
        double[][] matrix = {{Math.cos(radians), -Math.sin(radians)},
                {Math.sin(radians), Math.cos(radians)}};
        return matrix;
    }
    protected double[] RotatedVector(double theata, double[] v){
        return MatrixOperation2D(getRotationMatrix2D(theata), v);
    }

    public abstract void draw(Graphics g);
}
