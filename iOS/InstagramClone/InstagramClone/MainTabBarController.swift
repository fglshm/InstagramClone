//
//  MainTabbarController.swift
//  InstagramClone
//
//  Created by Shohei Maeno on 2019/06/30.
//  Copyright © 2019 Shohei Maeno. All rights reserved.
//

import UIKit

class MainTabBarController: UITabBarController {
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        view.backgroundColor = .white
        
        let homeViewController = HomeViewController()
        let searchViewController = SearchViewController()
        let postViewController = PostViewController()
        let likeViewController = LikeViewController()
        let profileViewController = ProfileViewController()
        
        homeViewController.tabBarItem.selectedImage = #imageLiteral(resourceName: "home_selected").withRenderingMode(.alwaysOriginal)
        homeViewController.tabBarItem.image = #imageLiteral(resourceName: "home_unselected").withRenderingMode(.alwaysOriginal)
        
        searchViewController.tabBarItem.selectedImage = #imageLiteral(resourceName: "search_selected").withRenderingMode(.alwaysOriginal)
        searchViewController.tabBarItem.image = #imageLiteral(resourceName: "search_unselected").withRenderingMode(.alwaysOriginal)
        
        postViewController.tabBarItem.image = #imageLiteral(resourceName: "post").withRenderingMode(.alwaysOriginal)
        
        likeViewController.tabBarItem.selectedImage = #imageLiteral(resourceName: "like_selected").withRenderingMode(.alwaysOriginal)
        likeViewController.tabBarItem.image = #imageLiteral(resourceName: "like_unselected").withRenderingMode(.alwaysOriginal)
        
        profileViewController.tabBarItem.selectedImage = #imageLiteral(resourceName: "profile_selected").withRenderingMode(.alwaysOriginal)
        profileViewController.tabBarItem.image = #imageLiteral(resourceName: "profile_unselected").withRenderingMode(.alwaysOriginal)
        
        viewControllers = [
            homeViewController, searchViewController, postViewController, likeViewController, profileViewController
        ]
        
        viewControllers?.forEach({
            $0.tabBarItem.imageInsets = .init(top: 8, left: 0, bottom: -8, right: 0)
        })
        
        
    }
    
}
