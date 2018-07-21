(ns app.views
  (:require [app.state :refer [app-state]]
            [app.events :refer [increment decrement]]
            [cljsjs.classnames]
            [cljsjs.react-input-autosize]
            [cljsjs.react-select]))

(defonce value (r/atom nil))

(defn header
  []
  [:div
   [:h1 "A template for reagent apps"]])

(defn counter
  []
  [:div
   [:button.btn {:on-click #(decrement %)} "-"]
   [:button {:disabled true} (get @app-state :count)]
   [:button.btn {:on-click #(increment %)} "+"]])(defonce value (r/atom nil))

(defn select-ui []
  [:> js/window.Select {:value @value
                        :options #js [#js {:value "a" :label "alpha"}
                                      #js {:value "b" :label "beta"}
                                      #js {:value "c" :label "gamma"}]
                        :onChange #(reset! value (aget % "value"))}])

(defn root-ui []
  [:div {:style {:width 400}}
   [:h3 "Select test"]
   [select-ui]])


(defn app []
  [:div
   [header]
   [counter]
   [root-ui]])
