package active.command;

/**
 * 通用命令接口
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-22 19:12
 */

public interface Command {
    /**
     * 执行命令
     *
     * @author LDB
     * @date 2023-01-22
     **/
    void execute();

    /**
     * 撤销命令
     *
     * @author LDB
     * @date 2023-01-22 23:14
     * @version 1.0
     */

    void undo();
}
