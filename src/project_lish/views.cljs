(ns project-lish.views
  (:require
   [re-frame.core :as re-frame]
   [project-lish.styles :as styles]
   [project-lish.config :as config]
   [project-lish.events :as events]
   [project-lish.routes :as routes]
   [project-lish.subs :as subs]
   ))

(defn- hello []
  [:div
   {:style {:background-color "white"
            :padding          "16px"
            :border-radius    "6px"
            :text-align "center"}} "Correct!"])

(defn- good-bye []
  [:div
   {:style {:background-color "white"
            :padding          "16px"
            :border-radius    "6px"
            :text-align "center"}} "Wrong answer!"])

(defn radio-component []
  [:fieldset
   [:legend "Select an answer"]
   [:div
    [:input {:type "radio" :id "a" :name "drone" :on-click #(re-frame/dispatch [:modal {:show? true
                                                                                        :child [good-bye]
                                                                                        :size :small}])}]
    [:label {:for "huey"} "Huey"]]
   [:div
    [:input {:type "radio" :id "b" :name "drone" :on-click #(re-frame/dispatch [:modal {:show? true
                                                                                        :child [good-bye]
                                                                                        :size :small}])}]
    [:label {:for "dewey"} "Dewey"]]
   [:div
    [:input {:type "radio" :id "c" :name "drone" :on-click #(re-frame/dispatch [:modal {:show? true
                                                                                        :child [good-bye]
                                                                                        :size :small}])}]
    [:label {:for "louie"} "Louie"]]
   [:div
    [:input {:type "radio" :id "d" :name "drone" :on-click #(re-frame/dispatch [:modal {:show? true
                                                                                        :child [hello]
                                                                                        :size :small}])}]
    [:label {:for "lish"} "Lish"]]
   ])

;;modal


(defn my-awesome-modal-fn []
  [:button
   {:title "Click to show modal!"
    :on-click #(re-frame/dispatch [:modal {:show? true
                                     :child [hello]
                                     :size :small}])} "The answer"])


(defn- close-modal []
  (re-frame/dispatch [:modal {:show? false :child nil}]))

(defn modal-panel
  [{:keys [child size show?]}]
  [:div {:class "modal-wrapper"}
   [:div {:class "modal-backdrop"
          :on-click (fn [event]
                      (do
                        (re-frame/dispatch [:modal {:show? (not show?)
                                              :child nil
                                              :size :default}])
                        (.preventDefault event)
                        (.stopPropagation event)))}]
   [:div {:class "modal-child"
          :style {:width (case size
                           :extra-small "15%"
                           :small "30%"
                           :large "70%"
                           :extra-large "85%"
                           "50%")}} child]])

(defn modal []
  (let [modal (re-frame/subscribe [:modal])]
    (fn []
      [:div
       (if (:show? @modal)
         [modal-panel @modal])])))
;; home
(defn home-panel []
  (let [name (re-frame/subscribe [::subs/name])]
    [:div
     [:h1
      {:class (styles/level1)}
      (str "Who's the best in the world?" )]

     (radio-component)
   ;  [:div
   ;   [:a {:on-click #(re-frame/dispatch [::events/navigate :about])}
   ;    "next"]]

     [modal]
     [:div
      {:style {:cursor "pointer"}}
      [:a {:on-click #(re-frame/dispatch [::events/navigate :q1])}
       "next"]]
     ]))

(defmethod routes/panels :home-panel [] [home-panel])

;; about

(defn about-panel []
  [:div
   [:h1 "This is the About Page."]

   [:div
    [:a {:on-click #(re-frame/dispatch [::events/navigate :home])}
     "go to Home Page"]]])

(defmethod routes/panels :about-panel [] [about-panel])


;; question 1

(defn q1-panel []
  [:div
   [:iframe {:width "600" :height "315"
             :src "https://www.youtube.com/embed/tgbNymZ7vqY"}]
   [radio-component]
   ;[my-awesome-modal-fn]
   [modal]
   [:div
    {:style {:cursor "pointer"}}
    [:a {:on-click #(re-frame/dispatch [::events/navigate :home])}
     "home"]]
   ])

(defmethod routes/panels :q1-panel [] [q1-panel])


(defmethod routes/panels :modal-panel [] [modal-panel])
;; main

(defn main-panel []
  (let [active-panel (re-frame/subscribe [::subs/active-panel])]
    (routes/panels @active-panel)))
