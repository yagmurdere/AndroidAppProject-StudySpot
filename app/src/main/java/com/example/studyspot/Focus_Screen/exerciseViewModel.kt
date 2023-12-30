package com.example.studyspot.Focus_Screen

import androidx.lifecycle.ViewModel
import com.example.studyspot.R

class exerciseViewModel:ViewModel() {
    val imageId = arrayOf(
        R.drawable.meditation_and_focus_image,
        R.drawable.meditation_and_focus_image,
        R.drawable.mental_break_activities_image,
        R.drawable.quick_scan_and_learn_image,
        R.drawable.concentration_meditation_image,
        R.drawable.time_management_skills_image
    )
    val exerciseNames = arrayOf(
        "Pomodoro Technique",
        "Meditation and Focus Exercises",
        "Mental Break Activities",
        "Quick Scan Glance, Learn",
        "Concentration Meditation",
        "Time Management Skills"
    )
    val headLine1=arrayOf(
        "What is the Pomodoro Technique?",
        "Breath Focused Meditation:",
        "Refreshing Mindful Breaks:",
        "Techniques for Instant Learning:",
        "Mental Clarity and Peace",
        "Effective Planning and Productivity"
        )
    val definitons1 = arrayOf(
        "The Pomodoro Technique is a working method developed to increase time management and productivity. Created by Francesco Cirillo in the 1980s, this technique suggests working uninterrupted for a certain period of time, followed by a short break. Pomodoro means tomato in Italian and is named after the shape of a kitchen timer (stopwatch) that Cirillo used.",
        "Breath-focused meditation is a classical meditation technique used to calm the mind, reduce stress and provide inner peace. This type of meditation involves one simply focusing on the breathing processes and carefully observing these processes. Here is a more detailed description of this technique:",
        "Mental break activities are effective practices designed to refresh the mind, reduce stress, and facilitate better digestion of learned information during study breaks. Here is a detailed explanation of these activities:",
        "This strategy signifies an approach designed to support efficient learning and quickly comprehend information. Here is a detailed explanation of the \"Quick Scan: Glance, Learn\" strategy:",
        "In the complexity of daily life, meditation is a powerful tool to increase concentration and achieve mental clarity. Concentration meditation is an effective method used to calm the mind, strengthen attention and promote inner peace.",
        "Time management skills can improve the quality of life by giving people the ability to be more effective and efficient in today's busy life pace. Here are detailed strategies that can be used to improve time management skills:"
    )
/*#################################*/
    val headLine2= arrayOf(
        "Choosing a Specific Task:",
        "Taking a Comfortable Position:",
        "Stress-Relief Meditation:",
        "Understanding the Context:",
        "Preparation:",
        "Goal Setting:"
        )
    val definitons2 = arrayOf(
        "The first step is to choose a specific task on which you can focus completely. This task should be small and specific enough to fit into a work period, usually 25 minutes.",
        "Before starting meditation, it is important to sit or lie down in a comfortable position. A correct sitting posture involves a meditation posture with your back straight, your shoulders relaxed, and your hands on your knees.",
        "Taking a short walk or performing stretching exercises can increase blood circulation, raising energy levels. Additionally, using simple meditation techniques to cope with stress can provide mental relaxation.",
        "First, it's crucial to understand the general context of the topic. Get an overview by glancing at titles, subtitles, and key terms.",
        "Sit in a comfortable position in a quiet environment. Close your eyes and start breathing comfortably. Turn inward from the outside world, feeling your body.",
        "Before starting time management, determine short- and long-term goals. Goals motivate daily planning and provide focus."
    )
/*#################################*/
    val headLine3= arrayOf(
        "Pomodoro Duration:",
        "Closing Your Eyes and Centering Yourself: ",
        "Resting Eyes by Staring into the Distance:",
        "Scanning Techniques:",
        "Breath Focus:",
        "Daily and Weekly Planning:"
    )
    val definitons3 = arrayOf(
        "Focus on your chosen task and work uninterrupted for 25 minutes. Do not switch to another task or allow distractions during this time.",
        "Close your eyes and take a few deep breaths. Imagine a peaceful and serene place, like a beach, forest, or meadow. Picture yourself there, absorbing the tranquility.",
        "Taking a moment to look into the distance to rest your eyes from computer or book screens can reduce eye strain and rejuvenate your focusing ability.",
        "Identify the specific topic you want to learn and quickly scan the text. Use scanning techniques to highlight main ideas, important details, and key points.",
        "Feel your breath deeply. Focus your attention on your breathing processes. With each breath, draw attention into the moment, maintaining internal focus.",
        "Create daily and weekly plans. These plans provide a clear picture of what you need to do and help you achieve your goals."
    )
/*#################################*/
    val headLine4= arrayOf(
        "Short Break:",
        "Paying Attention to the Breath:",
        "Short Coffee Break:",
        "Identifying Key Terms:",
        "Accepting Outside Thoughts:",
        "Time Stealers Identification:"
    )
    val definitons4 = arrayOf(
        "When the 25-minute study period is over, take a 5-minute break. During this break, get up, take a light walk, or look at a distant point to rest your eyes. Stay away from work completely during the break.",
        "Close your eyes and slowly direct your attention to your breathing processes. Breathe in through the nose and out through the mouth. Meanwhile, feel your breathing in its natural rhythm.",
        "Caffeine can enhance attention and alertness. However, it's essential to avoid excessive consumption. A short coffee break can help regain mental alertness.",
        "Identify key terms in the text and focus on understanding their meanings. This can help you grasp fundamental concepts.",
        "Accept the thoughts that arise in the mind without judgment. If thoughts of external factors come, gently notice them and return to your breathing.",
        "Identify the factors that waste your time. Be aware of time wasters such as the internet, social media or excessive meetings."
    )
/*#################################*/
    val headLine5= arrayOf(
        "Long Break After Every Four Pomodoros:",
        "Following the Breath Rhythm:",
        "Listening to Nature Sounds or Relaxing Music:",
        "Examining Visual Supports:",
        "Mantra Usage:",
        "Dividing into Parts:"
    )
    val definitons5 = arrayOf(
        "After every four completed Pomodoros, take a longer break (usually 15-30 minutes). This break will help you recharge and have a greater perspective. Advantages of the Pomodoro Technique:",
        "Begin to notice the rhythm of the breath. Concentrate your attention only on the sensations that occur during inhalation and exhalation. You can use your chest or abdomen to feel your breath.",
        "Listening to nature sounds or calming music can induce mental relaxation, reduce stress, and help you transition to the next study period with increased focus.",
        "Review visual supports such as graphics, tables, or images. This can aid in quickly understanding and retaining information.",
        "Repeating a simple word or phrase (mantra) can help focus the mind. Repeat the word you say, paying attention to every syllable.",
        "Breaking large tasks into smaller pieces helps you set more manageable and realistic goals."
    )
/*#################################*/
    val headLine6= arrayOf(
        "Improving Concentration: :",
        "Accepting Distracting Thoughts:",
        "Brief Reading Session:",
        "Summarizing:",
        "Body Awareness:",
        "Using Technology Effectively:"
    )
    val definitons6 = arrayOf(
        "Concentrating for a period of time can improve concentration and prevent distraction.",
        "You may be distracted during meditation. It's normal. As thoughts come and go, acknowledge them without judgment and focus your attention back on your breathing. Each breath offers an opportunity to bring your attention back into the moment.",
        "Reading a short story or an interesting article can be an excellent way to take a mental break. Opting for shorter and lighter materials is often more effective.",
        "After scanning the text, summarize main ideas and key information. This can reinforce what you've learned and enhance comprehension.",
        "Scan your body from head to toe. Relax and direct your awareness to every part of your body. This can increase mental focus.",
        "Organize and track tasks using technology tools like time management apps and calendar tools."
    )
/*#################################*/
    val headLine7= arrayOf(
        "Helps Time Management: ",
        "Engaging Your Senses:",
        "Mental Games and Puzzles:",
        "Defining Key Terms:",
        "Emptying the Mind:",
        "Break Strategies:"
    )
    val definitons7 = arrayOf(
        "Working and taking breaks for certain periods of time allows you to use time more effectively.",
        "Explore the mental scenery using all your senses. Feel the warmth of the sun, hear the rustling leaves, smell the fragrances around you, and immerse yourself fully in the visualization.",
        "Light mental activities, such as puzzles or brain games, can increase brain activity. Engaging in these activities can help maintain mental capacity even during relaxation.",
        "Define the key terms you identified during scanning and focus on understanding their meanings. This step contributes to a deeper understanding of the material.",
        "Empty the excess in the mind. With each breath, release inner turmoil. An empty mind can strengthen concentration.",
        "Take breaks at regular intervals by breaking your work processes into pieces. Taking breaks can help you regain your energy and focus."
    )
/*#################################*/
    val headLine8= arrayOf(
        "Increasing Motivation:",
        "Calming Down and Finding Peace:",
        "Deep Breathing Exercises and Yoga:",
        "Reviewing and Questioning:",
        "Return and Awareness:",
        "Continuous Improvement:"
    )
    val definitons8 = arrayOf(
        "Breaking tasks into smaller chunks makes things more manageable and achievable, which can increase motivation.",
        "Focusing on the process of breathing can, over time, reduce mental noise and increase your inner peace. This state of calm can result in increased inner clarity and serenity in those who practice meditation regularly.",
        "Deep breathing exercises and simple yoga movements can reduce stress and aid in refocusing mentally. These activities serve as an effective way to relax during study breaks.",
        "After a quick scan, review what you've learned and reinforce the information by questioning yourself. This can contribute to making the information more permanent.",
        "When you finish meditating, slowly open your eyes. Take a few deep breaths to strengthen awareness in the moment and enjoy this inner peace.",
        "Regularly review your time management strategies and constantly look for improvement opportunities. Be flexible and adapt to changing needs."
    )

}