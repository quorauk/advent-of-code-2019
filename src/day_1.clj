(ns day_1
  (:require [clojure.string :as str]))

(defn read-masses
  [file]
  (map read-string
    (-> file
      slurp
      (str/split #"\n")
    )
  )
)

(defn calculate-fuel
  [mass]
  (-> mass
    (/ 3)
    Math/floor
    (- 2)
    (max 0)
  )
)

(defn more-fuel
  ([mass]
    (more-fuel mass 0)
  )
  ([mass, total]
  (if (<= mass 0)
    total
    (
      recur (calculate-fuel mass) (+ total (calculate-fuel mass))
    )
  ))
)

(defn -main [file]
  (println
    "base fuel " (->> file
      read-masses
      (map calculate-fuel)
      (reduce +)
    )
  )
  (println
    "Fuel adds weight :O "
    (->> file
      read-masses
      (map more-fuel)
      (reduce +)
    )
  )
)