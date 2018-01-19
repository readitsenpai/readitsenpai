(ns readitsenpai.core
  (:gen-class)
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [hiccup.core :refer [html]]
            [compojure.core :refer :all]))

(defn words [str]
  (filter seq (clojure.string/split str #" ")))

(defn capitalize [str]
  (->> str
       (words)
       (map clojure.string/capitalize)
       (clojure.string/join " ")))

(defn page [name]
  [:body
   [:div "Hello, " [:b (capitalize name)] "!"]])

(defroutes app
  (GET "/" []
    (html (page "world")))
  (GET "/:name" [name]
    (html (page name))))

(defonce server
  (run-jetty app {:port  3000
                  :join? false}))
