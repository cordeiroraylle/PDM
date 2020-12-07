//
//  ViewController.swift
//  Navigation Controller
//
//  Created by raylle on 06/12/20.
//  Copyright © 2020 raylle. All rights reserved.
//

import UIKit

class Tela1ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        print("Tela 1 : View Did Load")
    }
    
    override func viewWillAppear(_ animated: Bool){
         super.viewWillAppear(true)
         print("Tela 1 : View Will Appear")
     }
    
    override func viewDidAppear(_ animated: Bool){
        super.viewDidAppear(true)
        print("Tela 1 : View Did Appear")
    }
    
     override func viewWillDisappear(_ animated: Bool){
          super.viewWillDisappear(true)
          print("Tela 1 : View Will Disappear")
      }
     
     override func viewDidDisappear(_ animated: Bool){
         super.viewDidDisappear(true)
         print("Tela 1 : View Did Disappear")
     }

}
