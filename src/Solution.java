

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution {

    class Cell {
        int i;
        int j;

        public Cell (int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Cell cell = (Cell) o;

            if (i != cell.i) {
                return false;
            }
            if (j != cell.j) {
                return false;
            }

            return true;
        }

        @Override
        public int hashCode() {
            int result = i;
            result = 31 * result + j;
            return result;
        }

    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> resultOfWords = new LinkedList<String>();

        if (board == null || board.length == 0 || words == null || words.length == 0) {
            return resultOfWords;
        }

        Trie dictionary = new Trie();
        for (int i = 0; i < words.length; i++) {
            dictionary.insert(words[i]);
        }

        int m = board.length;
        int n = board[0].length;


        HashSet<String> resSet = new HashSet<String>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                HashSet<Cell> used = new HashSet<Cell>();
                StringBuilder sb = new StringBuilder();
                String prefix = "" + board[i][j];
                if (dictionary.startsWith(prefix)) {
                    sb.append(prefix);
                    Cell start =  new Cell(i, j);
                    used.add(start);
                    findWordsHelper(board, start, m, n, sb, used, resSet, dictionary);
                }
            }
        }
        resultOfWords.addAll(resSet);
        return resultOfWords;
    }

    private void findWordsHelper(char[][] board, Cell current, int m, int n, StringBuilder sb, HashSet<Cell> used, Set<String> res, Trie dictionary) {

        String prefix = sb.toString(); // assume is correct prefix with the current cell added to sb



        if (dictionary.search(prefix)) {
            res.add(prefix);
        }

        List<Cell> adjacentUnusedCells = getAdjacentUnusedCells(current, m, n, used);
        if (adjacentUnusedCells.isEmpty()) {
            return;
        }
        for (Cell neigh : adjacentUnusedCells) {
            char nextChar = board[neigh.i][neigh.j];
            String nextPrefix = prefix + nextChar;
            if (dictionary.startsWith(nextPrefix)) {
                used.add(neigh);
                sb.append(nextChar);
                findWordsHelper(board, neigh, m, n, sb, used, res, dictionary);
                used.remove(neigh);
                sb.deleteCharAt(nextPrefix.length() - 1);
            }

        }
    }

    private List<Cell> getAdjacentUnusedCells(Cell cur, int m, int n, HashSet<Cell> used) {
        int i = cur.i;
        int j = cur.j;

        List<Cell> cells = new LinkedList<Cell>();

        if (i - 1 >= 0) {
            Cell candidateNeighbor = new Cell(i - 1, j);

            if (!used.contains(candidateNeighbor)) {
                cells.add(candidateNeighbor);
            }
        }

        if (i + 1 <= m - 1) {
            Cell candidateNeighbor = new Cell(i + 1, j);

            if (!used.contains(candidateNeighbor)) {
                cells.add(candidateNeighbor);
            }
        }

        if (j - 1 >= 0) {
            Cell candidateNeighbor = new Cell(i, j - 1);

            if (!used.contains(candidateNeighbor)) {
                cells.add(candidateNeighbor);
            }
        }

        if (j + 1 <= n - 1) {
            Cell candidateNeighbor = new Cell(i, j + 1);

            if (!used.contains(candidateNeighbor)) {
                cells.add(candidateNeighbor);
            }
        }

        return cells;

    }

}