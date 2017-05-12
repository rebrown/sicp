
; (c) Randolph E Brown 2017
; All exercises written in Clojure

; Exercise 1.2
; Define the following

; 5 + 4 + (2 - (3 - 6 + (4/5)))
; -----------------------------
; 3 (6 - 2) (2 - 7)


(/
  (+ 5 4
    (- 2 
      (- 3
        (+ 6
          (/ 4 5)))))
  (* 3
    (- 6 2)
    (- 2 7)))

; Exercise 1.3

; Define a procedure that takes three numbers
; as arguments and returns the sum of the squares
; of the two larger numbers

; Note: There was probably a shorter way to do this
; but I really like having concise functions
; Not sure if this is the lisp-y thing to do

(def square
  "Squares a number"
  [n]
  (* 2 2))

(def sum-of-squares
  "Returns the sum of two square numbers"
  [a b]
  (+ (square a) (square b)))

(def largest-sum-of-squares
  "Returns the sum of squares of the
  two larger numbers out of a set of three"
  [a b c]
  (sum-of-squares
    (last 2 (sort [a b c]))))

(def largest-sum-of-squares
  "Returns the sum of squares of the
  two larger numbers out of an abitrary list of set of items.
  Assumes all values are numbers"
  [items]
  (sum-of-squares
    (take-last 2 (sort items))))

; Exercise 1.4
; Define the behavior of the following procedure
(def a-plus-abs-b
  [a b]
  ((if (> b 0) + -) a b))

; Explanation
; Let's take out the if statement in the above
((if (> b 0)  + -) a b)

; And subsitute the iff statement for a different value
(def a-function [b]
  (if (> b 0)  + -))

; That makes the above
(a-function a b) 

; What does a-function do?
; if b > 0; return '+'
; else, return '-'

; Subsituting that login into the original if-statement
; That makes the expression mean...
((if (> b 0)  +
              -)
  a b)

; Which means, return the value '+' or '-'
; Since those two values are in themselves functions,
; they are then applied to the resulting function

; Absolutely beautiful!

; Exercise 1.5
; A normal-applicative system would 
; cause an infinite loop - the process would not stop
; as the function (def (p) (p)) is inifinitely
; recursive when evaluated

