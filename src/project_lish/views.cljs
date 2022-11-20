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
    [:label {:for "huey"} "Enter a PACMN ticket request"]]
   [:div
    [:input {:type "radio" :id "b" :name "drone" :on-click #(re-frame/dispatch [:modal {:show? true
                                                                                        :child [good-bye]
                                                                                        :size :small}])}]
    [:label {:for "dewey"} "Create a mod in CAMS"]]
   [:div
    [:input {:type "radio" :id "c" :name "drone" :on-click #(re-frame/dispatch [:modal {:show? true
                                                                                        :child [hello :q2]
                                                                                        :size :small}])}]
    [:label {:for "louie"} "Send to the PM for review and approval"]]
   [:div
    [:input {:type "radio" :id "d" :name "drone" :on-click #(re-frame/dispatch [:modal {:show? true
                                                                                        :child [good-bye]
                                                                                        :size :small}])}]
    [:label {:for "lish"} "Sign the mod"]]
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
                                                                                        :child [hello :end]
                                                                                        :size :small}])}]
    [:label {:for "lish"} "Robby"]]
   ])

(defn q6 []
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
                                                                                        :child [hello :video-panel]
                                                                                        :size :small}])}]
    [:label {:for "lish"} "Boo Boo"]]])
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
      (str "Welcome to Contracts - let's get started learning about Modifications." )]
     [:div
      {:style {:cursor "pointer"}}
      [:a {:on-click #(re-frame/dispatch [::events/navigate :q1])}
       "Click Here to Begin!"]]
     ]))

(defmethod routes/panels :home-panel [] [home-panel])

;; question 1

(defn q1-panel []
  [:div
   [:h1 "You just received a mod, what is the first thing you do?"]
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
    [:h1 "After receiving PM approval, what should you do next?"]
   [q2]
   [modal]
   [:div
    {:style {:cursor "pointer"}}
    ]])

(defmethod routes/panels :q2-panel [] [q2-panel])


;; question 3

(defn q3-panel []
  [:div
  [:h1 "When reviewing the mod against CAMS and the previous mod award, "
   [:br] "what things should you look for first?"]
   [q3]
   [modal]
   [:div
    {:style {:cursor "pointer"}}
    ]])

(defmethod routes/panels :q3-panel [] [q3-panel])

;; question 4

(defn q4-panel []
  [:div
    [:h1 "After confirming the mod is correct, what should you do next?"]
   [q4]
   [modal]
   [:div
    {:style {:cursor "pointer"}}
    ]])

(defmethod routes/panels :q4-panel [] [q4-panel])



;; question 5

(defn q5-panel []
  [:div
  [:h1 "After signing the mod, what is the last thing you should do?"]
   [q5]
   [modal]
   [:div
    {:style {:cursor "pointer"}}
    ]])

(defmethod routes/panels :q5-panel [] [q5-panel])



;; question 6

(defn q6-panel []
  [:div
   ;; place holder question
   [q6]
   [modal]
   [:div
    {:style {:cursor "pointer"}}]])

(defmethod routes/panels :q6-panel [] [q6-panel])

;; ending video

(defn end-panel []
  [:div
   [:h1 "Wrapping up - click play on the video below to view a quick example"
   [:br] "of how to process a modification for GSA07.MEGAStar."]
   [:iframe {:width "600" :height "315"
             :src "https://www.youtube.com/embed/tgbNymZ7vqY"}]
   [:div
    {:style {:cursor "pointer"}}
    [:a {:on-click #(re-frame/dispatch [::events/navigate :home])}
     "home"]]])

(defmethod routes/panels :end-panel [] [end-panel])

;; main

(defn main-panel []
  (let [active-panel (re-frame/subscribe [::subs/active-panel])]
    (routes/panels @active-panel)))
