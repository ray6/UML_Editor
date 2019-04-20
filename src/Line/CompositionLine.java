package Line;

import BasicObject.Port;

import java.awt.*;

public class CompositionLine extends Line {
    private int point_num = 4;
    private int dimension = 2;
    public CompositionLine(Port start, Port end){
        super(start, end);
    }
    private int[][] getDiamond(int x1, int y1, int x2, int y2){
        int[][] points = new int[dimension][point_num];
        double[] point = new double[dimension];
        double norm = Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
        int len = 20;
        double[] v = { ((x1-x2)/norm)*len, ((y1-y2)/norm)*len };

        double[][] rotate_matrix = getRotationMatrix(45.0);
        point = MatrixOperation(rotate_matrix, v);
        points[0][0] = (int)point[0]+x2; // x
        points[1][0] = (int)point[1]+y2; // y

        points[0][1] = x2;
        points[1][1] = y2;

        rotate_matrix = getRotationMatrix(-45.0);
        point = MatrixOperation(rotate_matrix, v);
        points[0][2] = (int)point[0]+x2; // x
        points[1][2] = (int)point[1]+y2; // y

        points[0][3] = x2+(int)(v[0]*Math.sqrt(2));
        points[1][3] = y2+(int)(v[1]*Math.sqrt(2));


        return points;
    }
    private double[] MatrixOperation(double[][] matrix, double[] xy){
        double[] ans = new double[xy.length];
        for (int i = 0; i < xy.length; i++){
            ans[i] = 0;
            for (int j = 0; j<xy.length;j++){
                ans[i] = ans[i] + matrix[i][j]*xy[j];
            }
        }
        return ans;
    }
    private double[][] getRotationMatrix(double theata){
        double[][] matrix = new double[2][2];
        matrix[0][0] = Math.cos(Math.toRadians(theata));
        matrix[0][1] = -Math.sin(Math.toRadians(theata));
        matrix[1][0] = Math.sin(Math.toRadians(theata));
        matrix[1][1] = Math.cos(Math.toRadians(theata));
        return matrix;
    }
    @Override
    public void drawline(Graphics g) {
        g.setColor(Color.black);
        g.drawLine(Start.getCenterX(), Start.getCenterY(), End.getCenterX(), End.getCenterY());
        int[][] points = getDiamond(Start.getCenterX(), Start.getCenterY(), End.getCenterX(), End.getCenterY());
        //points[0] : x coordinate
        //points[1] : y coordinate
        g.fillPolygon(points[0], points[1], point_num);
    }
}
