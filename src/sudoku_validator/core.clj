(ns sudoku-validator.core
  (:require [clojure.set :refer [difference]]))

(def valid-set #{1 2 3 4 5 6 7 8 9})

(defn valid-seq?
  [line]
  (empty? (difference valid-set line)))

(defn- transpose-sudoku
  [sudoku-matrix]
  (apply mapv vector sudoku-matrix))

(defn- matrix-to-squares
  [sudoku-matrix]
  (loop [i 0 squares []]
    (if-not (< i 9)
      squares
      (recur (+ i 3)
             (into squares
                   (partition 9 (apply concat (map #(take 3 (drop i %)) sudoku-matrix))))))))

(defn valid-sudoku?
  [matrix]
  (every? identity
          ;; rows
          (concat (map valid-seq? matrix)
                  ;; columns
                  (map valid-seq? (transpose-sudoku matrix))
                  ;; squares
                  (map valid-seq? (matrix-to-squares matrix)))))
