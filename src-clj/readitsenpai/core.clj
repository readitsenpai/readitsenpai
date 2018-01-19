(ns readitsenpai.core
  (:gen-class)
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [ring.middleware.reload :refer [wrap-reload]]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [hiccup.core :refer [html]]
            [hiccup.page :refer [include-js]]
            [compojure.core :refer :all]
            [compojure.route :refer [resources]]))

(defn words [str]
  (filter seq (clojure.string/split str #" ")))

(defn capitalize [str]
  (->> str
    (words)
    (map clojure.string/capitalize)
    (clojure.string/join " ")))

(defn page [name]
  [:body
   [:div "Hello " [:b (capitalize name)] "!!"]
   (include-js "/js/main.js")])

(defroutes router
  (GET "/" [name]
    (html (page (or name "world"))))
  (resources "/"))

(def handler
  (-> router
    (wrap-reload)
    (wrap-defaults site-defaults)))

(defonce server
  (run-jetty handler {:port 3000, :join? false}))
