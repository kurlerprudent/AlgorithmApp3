import java.util.Scanner;

class StrassenMatrixMultiplication {
private int[][] A;
private int[][] B;
private int[][] C;

public StrassenMatrixMultiplication() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the number of rows and columns of the matrices: ");
    int n = scanner.nextInt();

    A = new int[n][n];
    B = new int[n][n];
    C = new int[n][n];

    System.out.println("Enter the elements of the first matrix:");
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            A[i][j] = scanner.nextInt();
        }
    }

    System.out.println("Enter the elements of the second matrix:");
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            B[i][j] = scanner.nextInt();
        }
    }
}

public void multiply() {
    C = strassenMultiply(A, B);
    System.out.println("The result of matrix multiplication is:");
    printMatrix(C);
}

private int[][] strassenMultiply(int[][] A, int[][] B) {
    int n = A.length;
    int[][] C = new int[n][n];

    if (n == 1) {
        C[0][0] = A[0][0] * B[0][0];
    } else {
        int mid = n / 2;
        int[][] A11 = new int[mid][mid];
        int[][] A12 = new int[mid][mid];
        int[][] A21 = new int[mid][mid];
        int[][] A22 = new int[mid][mid];
        int[][] B11 = new int[mid][mid];
        int[][] B12 = new int[mid][mid];
        int[][] B21 = new int[mid][mid];
        int[][] B22 = new int[mid][mid];

        splitMatrix(A, A11, 0, 0);
        splitMatrix(A, A12, 0, mid);
        splitMatrix(A, A21, mid, 0);
        splitMatrix(A, A22, mid, mid);
        splitMatrix(B, B11, 0, 0);
        splitMatrix(B, B12, 0, mid);
        splitMatrix(B, B21, mid, 0);
        splitMatrix(B, B22, mid, mid);

        int[][] P1 = strassenMultiply(add(A11, A22), add(B11, B22));
        int[][] P2 = strassenMultiply(add(A21, A22), B11);
        int[][] P3 = strassenMultiply(A11, sub(B12, B22));
        int[][] P4 = strassenMultiply(A22, sub(B21, B11));
        int[][] P5 = strassenMultiply(add(A11, A12), B22);
        int[][] P6 = strassenMultiply(sub(A21, A11), add(B11, B12));
        int[][] P7 = strassenMultiply(sub(A12, A22), add(B21, B22));

        int[][] C11 = add(sub(add(P1, P4), P5), P7);
        int[][] C12 = add(P3, P5);
        int[][] C21 = add(P2, P4);
        int[][] C22 = add(sub(add(P1, P3), P2), P6);

        mergeMatrix(C, C11, 0, 0);
        mergeMatrix(C, C12, 0, mid);
        mergeMatrix(C, C21, mid, 0);
        mergeMatrix(C, C22, mid, mid);
    }

    return C;
}

private void splitMatrix(int[][] A, int[][] subA, int iStart, int jStart) {
    for (int i = 0; i < subA.length; i++) {
        for (int j = 0; j < subA.length; j++) {
            subA[i][j] = A[i + iStart][j + jStart];
        }
    }
}

private void mergeMatrix(int[][] C, int[][] subC, int iStart, int jStart) {
    for (int i = 0; i < subC.length; i++) {
        for (int j = 0; j < subC.length; j++) {
            C[i + iStart][j + jStart] = subC[i][j];
        }
    }
}

private int[][] add(int[][] A, int[][] B) {
    int n = A.length;
    int[][] C = new int[n][n];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            C[i][j] = A[i][j] + B[i][j];
        }
    }
    return C;
}

private int[][] sub(int[][] A, int[][] B) {
    int n = A.length;
    int[][] C = new int[n][n];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            C[i][j] = A[i][j] - B[i][j];
        }
    }
    return C;
}

private void printMatrix(int[][] C) {
    for (int i = 0; i < C.length; i++) {
        for (int j = 0; j < C.length; j++) {
            System.out.print(C[i][j] + " ");
        }
        System.out.println();
    }
}
}