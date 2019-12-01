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
  )
)

(defn -main [file]
  (println
    (->> file
      read-masses
      (map calculate-fuel)
      (reduce +)
    )
  )
)