(defn size [v]
  (loop [l v, c 0]
    (if (empty? l)
      c
      (recur (rest l) (inc c)))))

(defn add [v]
  (loop [l v, c 0]
    (if (empty? l)
      c
      (recur (rest l) (+ (first l) c)))))

(defn bensMap [f l]
  (loop [d f, s l,e []]
  (if (empty? s)
    (reverse e)
    (recur d (rest s) (cons (d (first s)) e))))) 
;Map Usage: (bensMap (fn [number] (+ 5 number)) [1 2 3 4 5])

;comprehension to combine lists including a filter
(def colors ["Red" "Orange" "Yellow" "Green" "Blue" "Indigo" "Violet"])
(def vehicles ["Cars" "Trucks" "Motorcycles" "Vans" "SUVs" "Semis"])
(for [x colors, y vehicles, :when ((fn [word] (> (count word) 4)) x)] (str "I like " x " " y))


;Factorial
(defn fac [a] 
	(take a
	      (map first
		   (iterate (fn [[p n]] [(* p n) (inc n)]) [1 2]))))

(defmacro unless [t b]
  (list 'if (list 'not t) b))

(defmacro n [t]
  (list 'not t))

(defn create
  []
  (atom {}))

(defn get
  [cache key]
  (@cache key))

(defn put
  ([cache value-map]
     (swap! cache merge value-map))
  ([cache key value]
     (swap! cache assoc key value)))

