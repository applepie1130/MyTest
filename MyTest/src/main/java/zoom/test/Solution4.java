package zoom.test;

import java.util.ArrayList;
import java.util.List;

public class Solution4 {
    private int size = 0;
    private int[] stack = new int[100_000];
    List<int[]> stackPool = new ArrayList<>();
    List<Integer> sizePool = new ArrayList<>();

    public int push(int element) {
        return add(size, element);
    }

    public void pop() {
        remove(size - 1);
    }

    public int top() {
        if (size == 0)
            return 0;
        else
            return stack[size - 1];
    }

    private int add(int $index, int element) {
        if ($index > size || $index < 0) {
            throw new IndexOutOfBoundsException();
        }
        int index = this.size;
        if (index > 0) {
            do {
                stack[index] = stack[index - 1];
            } while (--index > $index);
        }
        stack[$index] = element;
        return ++this.size;
    }

    private int remove(int i) {
        if (i > size || i < 0) {
            return 0;
        }
        int removed = stack[i];
        while (i < this.size) {
            stack[i] = stack[++i];
        }
        stack[size--] = 0;
        return removed;
    }

    public void begin() {
        stackPool.add(stack.clone());
        sizePool.add(size);
    }

    public boolean rollback() {
        int memoryPoolSize = stackPool.size();
        boolean rollbackResult = memoryPoolSize > 0;
        if (rollbackResult) {
            stack = stackPool.get(memoryPoolSize - 1);
            size = sizePool.get(memoryPoolSize - 1);
            stackPool.remove(memoryPoolSize - 1);
            sizePool.remove(memoryPoolSize - 1);
        }
        return rollbackResult;
    }

    public boolean commit() {
        int memoryPoolSize = stackPool.size();
        boolean commitResult = memoryPoolSize > 0;
        if (commitResult) {
            stackPool.remove(memoryPoolSize - 1);
            sizePool.remove(memoryPoolSize - 1);
        }
        return commitResult;
    }

    public static void test() {
        Solution4 sol = new Solution4();
        sol.push(4);
        sol.begin(); // start transaction 1
        sol.push(7); // stack: [4,7]
        sol.begin(); // start transaction 2
        sol.push(2); // stack: [4,7,2]
        assert sol.rollback() == true; // rollback transaction 2
        assert sol.top() == 7; // stack: [4,7]
        sol.begin(); // start transaction 3
        sol.push(10); // stack: [4,7,10]
        assert sol.commit() == true; // transaction 3 is committed
        assert sol.top() == 10;
        assert sol.rollback() == true; // rollback transaction 1
        assert sol.top() == 4; // stack: [4]
        assert sol.commit() == false; // there is no open transaction
    }
};