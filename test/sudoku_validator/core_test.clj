(ns sudoku-validator.core-test
  (:require [clojure.test :refer :all]
            [sudoku-validator.core :refer :all]))

(def valid-1
  [[9 4 7 8 5 6 1 2 3]
   [2 3 1 9 4 7 5 6 8]
   [5 6 8 2 3 1 7 4 9]
   [8 2 6 4 7 3 9 1 5]
   [1 7 4 5 8 9 2 3 6]
   [3 5 9 1 6 2 8 7 4]
   [6 9 3 7 2 8 4 5 1]
   [4 8 2 6 1 5 3 9 7]
   [7 1 5 3 9 4 6 8 2]])

(def valid-2
  [[8 6 2 4 1 3 9 7 5]
   [9 5 3 7 8 6 4 1 2]
   [1 7 4 9 2 5 6 8 3]
   [3 4 7 6 9 1 2 5 8]
   [5 2 1 3 4 8 7 6 9]
   [6 8 9 5 7 2 1 3 4]
   [7 3 6 2 5 4 8 9 1]
   [2 1 5 8 6 9 3 4 7]
   [4 9 8 1 3 7 5 2 6]])

(def invalid-1
  [[9 4 7 7 5 6 1 2 3]
   [2 3 1 9 4 7 5 6 8]
   [5 6 8 2 3 1 7 4 9]
   [8 2 6 4 7 3 9 1 5]
   [1 7 4 5 8 9 2 3 6]
   [3 5 9 1 6 2 8 7 4]
   [6 9 3 7 2 8 4 5 1]
   [4 8 2 6 1 5 3 9 7]
   [7 1 5 3 9 4 6 8 2]])

(def invalid-2
  [[8 6 2 4 1 3 9 7 5]
   [9 5 3 7 8 6 4 1 2]
   [1 7 4 9 2 5 6 8 3]
   [3 4 7 6 9 1 2 5 8]
   [5 2 1 3 4 8 7 6 9]
   [6 8 9 5 7 2 1 3 4]
   [7 3 6 2 5 4 8 9 1]
   [2 1 5 8 2 9 3 4 7]
   [4 9 8 1 3 7 5 2 6]])

(def valid-line [9 4 7 8 5 6 1 2 3])

(def invalid-line [9 9 7 8 5 6 1 2 3])

(deftest valid-seq-test
  (testing "Validating a sequence input"
    (is (= (valid-seq? valid-line) true))
    (is (= (valid-seq? invalid-line) false))))

(deftest valid-sudoku-test
  (is (= (valid-sudoku? valid-1) true))
  (is (= (valid-sudoku? invalid-1) false))
  (is (= (valid-sudoku? valid-2) true))
  (is (= (valid-sudoku? invalid-2) false)))


