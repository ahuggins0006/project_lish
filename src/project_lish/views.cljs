(ns project-lish.views
  (:require
   [re-frame.core :as re-frame]
   [project-lish.styles :as styles]
   [project-lish.config :as config]
   [project-lish.events :as events]
   [project-lish.routes :as routes]
   [project-lish.subs :as subs]
   ))

(defn- close-modal []
  (re-frame/dispatch [:modal {:show? false :child nil}]))

(defn- hello [next-question]
  [:div
   {:style {:background-color "white"
            :padding          "16px"
            :border-radius    "6px"
            :text-align "center"}} "Correct!"
   [:div
    {:style {:cursor "pointer"}}
    [:a {:on-click #(do (close-modal) (re-frame/dispatch [::events/navigate next-question]))}
     "next"]]
   ]
  )

(defn- good-bye []
  [:div
   {:style {:background-color "white"
            :padding          "16px"
            :border-radius    "6px"
            :text-align "center"}} "Wrong answer!"])

(defn q1 []
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
                                                                                        :child [hello :q2]
                                                                                        :size :small}])}]
    [:label {:for "lish"} "Lish"]]
   ])

(defn q2 []
  [:fieldset
   [:legend "Select an answer"]
   [:div
    [:input {:type "radio" :id "a" :name "drone" :on-click #(re-frame/dispatch [:modal {:show? true
                                                                                        :child [good-bye]
                                                                                        :size :small}])}]
    [:label {:for "huey"} "Hue"]]
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
                                                                                        :child [hello :q3]
                                                                                        :size :small}])}]
    [:label {:for "lish"} "Lish"]]
   ])

(defn q3 []
  [:fieldset
   [:legend "Select an answer"]
   [:div
    [:input {:type "radio" :id "a" :name "drone" :on-click #(re-frame/dispatch [:modal {:show? true
                                                                                        :child [good-bye]
                                                                                        :size :small}])}]
    [:label {:for "huey"} "Hue"]]
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
                                                                                        :child [hello :q4]
                                                                                        :size :small}])}]
    [:label {:for "lish"} "Bib"]]
   ])

(defn q4 []
  [:fieldset
   [:legend "Select an answer"]
   [:div
    [:input {:type "radio" :id "a" :name "drone" :on-click #(re-frame/dispatch [:modal {:show? true
                                                                                        :child [good-bye]
                                                                                        :size :small}])}]
    [:label {:for "huey"} "Hue"]]
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
                                                                                        :child [hello :q5]
                                                                                        :size :small}])}]
    [:label {:for "lish"} "Boo Boo"]]
   ])

(defn q5 []
  [:fieldset
   [:legend "Select an answer"]
   [:div
    [:input {:type "radio" :id "a" :name "drone" :on-click #(re-frame/dispatch [:modal {:show? true
                                                                                        :child [good-bye]
                                                                                        :size :small}])}]
    [:label {:for "huey"} "Hue"]]
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
                                                                                        :child [hello :home]
                                                                                        :size :small}])}]
    [:label {:for "lish"} "Robby"]]
   ])
;;modal


(defn my-awesome-modal-fn []
  [:button
   {:title "Click to show modal!"
    :on-click #(re-frame/dispatch [:modal {:show? true
                                     :child [hello]
                                     :size :small}])} "The answer"])



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

(defmethod routes/panels :modal-panel [] [modal-panel])

;; home
(defn home-panel []
  (let [name (re-frame/subscribe [::subs/name])]
    [:div
     [:h1
      {:class (styles/level1)}
      (str "Welcome to Lish's link!" )]
     [:div
      {:style {:cursor "pointer"}}
      [:a {:on-click #(re-frame/dispatch [::events/navigate :q1])}
       "next"]]
     ]))

(defmethod routes/panels :home-panel [] [home-panel])

;; question 1

(defn q1-panel []
  [:div
   [:iframe {:width "600" :height "315"
             :src "https://www.youtube.com/embed/tgbNymZ7vqY"}]
   [q1]
   [modal]
   [:div
    {:style {:cursor "pointer"}}
    ]
   ])

(defmethod routes/panels :q1-panel [] [q1-panel])


;; question 2

(defn q2-panel []
  [:div
   [:h1 "Who is the greatest in the world?"]
   [q2]
   [modal]
   [:div
    {:style {:cursor "pointer"}}
    ]])

(defmethod routes/panels :q2-panel [] [q2-panel])


;; question 3

(defn q3-panel []
  [:div
   [:h1 "Who is the biggest in the world?"]
   [q3]
   [modal]
   [:div
    {:style {:cursor "pointer"}}
    ]])

(defmethod routes/panels :q3-panel [] [q3-panel])

;; question 4

(defn q4-panel []
  [:div
   [:h1 "Who stinks?"]
   [q4]
   [modal]
   [:div
    {:style {:cursor "pointer"}}
    ]])

(defmethod routes/panels :q4-panel [] [q4-panel])



;; question 5

(defn q5-panel []
  [:div
   [:h1 "Who is red?"]
   [q5]
   [modal]
   [:div
    {:style {:cursor "pointer"}}
    ]])

(defmethod routes/panels :q5-panel [] [q5-panel])
;; main

(defn main-panel []
  (let [active-panel (re-frame/subscribe [::subs/active-panel])]
    (routes/panels @active-panel)))
