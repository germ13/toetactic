(ns toetactic.core
  (:gen-class))

(def initial-board
  ; player one is :2 
  ; player two is :5
  [[2 5 0]
   [0 5 5]
   [0 5 2]])

(defn get-row
  "returns row at index row from board"
  [board row]
  (nth board row))

(defn get-column [board column]
  [(nth (nth board 0) column)
   (nth (nth board 1) column)
   (nth (nth board 2) column)])

(defn check-rows-for-win [board]
  (let [products (map #(reduce * %) board)]
    (cond
      (.contains products 8) :2
      (.contains products 125) :5
      :else nil)))

(defn transpose [board]
  [(get-column board 0)
   (get-column board 1)
   (get-column board 2)])

(defn check-columns-for-win [board]
  (let [products (map #(reduce * %) (transpose board))]
    (cond
      (.contains products 8) :2
      (.contains products 125) :5
      :else nil)))

;; (defn is-valid-move? [board row column]
;;   (= 0 (nth (nth board column) row)))

;; (defn makemove [board row column player]
;;   (assoc board
;;          row (assoc (nth board row) column player)))

(defn -main []
  (let [board initial-board]
    (println (check-rows-for-win board))
    (println "----")
    (println (check-columns-for-win board)))

  ;; (print (makemove initial-board 2 1 :x))
  ;; (print (makemove initial-board 1 2 :y)))
  ;; )
  )