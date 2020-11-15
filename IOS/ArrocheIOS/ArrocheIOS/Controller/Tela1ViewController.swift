//
//  ViewController.swift
//  ArrocheIOS
//
//  Created by raylle on 14/11/20.
//

import UIKit

class Tela1ViewController: UIViewController {

    var jogo = Arroche()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        print("\(jogo.display())")
    }
    
    @IBOutlet weak var lbLimites: UILabel!
    @IBOutlet weak var tfChute: UITextField!
    
    @IBAction func btChutar(_ sender: Any) {
        
        if jogo.jogando {
            if let chute = Int(tfChute.text!) {
                jogo.chutar(chute: chute)
                
                if jogo.resultado == "você ganhou"{
                    let tela2vc = storyboard?.instantiateViewController(identifier: "Tela2") as! Tela2ViewController
                    self.present(tela2vc, animated: true, completion: nil)
                }
                if jogo.resultado == "você perdeu"{
                    let tela3vc = storyboard?.instantiateViewController(identifier: "Tela3") as! Tela3ViewController
                    self.present(tela3vc, animated: true, completion: nil)
                }
            }
            self.lbLimites.text = "Chute um número entre \(jogo.linicial) e \(jogo.lfinal)"
        }
  
    }
    
    @IBAction func btNovoJogo(_ sender: Any) {
        self.jogo = Arroche()
        self.lbLimites.text = "Chute um número entre \(jogo.linicial) e \(jogo.lfinal)"
        print("\(jogo.display())")
    }
}

