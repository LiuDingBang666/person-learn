package create.flyweight;

import lombok.Data;

/**
 * @author LDB
 * @version 1.0
 * @date 2023-01-25 10:34
 */

@Data
public class TreeManager {
    Tree[][] treeArray;

    void displayTrees() {
        for (int i = 0; i < treeArray.length; i++) {
            for (int j = 0; j < treeArray[i].length; j++) {
                treeArray[i][j].display(treeArray[i][j].x, treeArray[i][j].y, treeArray[i][j].age);
            }
        }
    }
}
