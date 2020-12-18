//
//  ViewController.swift
//  pessoas
//
//  Created by raylle on 17/12/20.
//  Copyright © 2020 raylle. All rights reserved.
//

import UIKit

class FormViewController: UIViewController {

    @IBOutlet weak var tfNome: UITextField!
    @IBOutlet weak var tfIdade: UITextField!
    
    var cadastro: Cadastro?
    var editIndex: Int?
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(true)
        if self.editIndex! != -1 {
            let pessoa = self.cadastro?.get(index: editIndex!)
            self.tfNome.text = pessoa!.nome
            self.tfIdade.text = String(pessoa!.idade)
        }
    }
    
    @IBAction func salvar(_ sender: Any) {
        let nome = self.tfNome.text!
        let idade = Int(self.tfIdade.text!)
        
        let pessoa = Pessoa(nome: nome, idade: idade!)
        
        if self.editIndex! == -1{
            self.cadastro?.add(pessoa: pessoa)
        }else{
            self.cadastro?.update(index: editIndex!, pessoa: pessoa)
        }
        
        self.navigationController?.popViewController(animated: true)
    }
}

