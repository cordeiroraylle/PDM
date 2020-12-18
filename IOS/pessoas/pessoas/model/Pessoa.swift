//
//  Pessoa.swift
//  pessoas
//
//  Created by raylle on 17/12/20.
//  Copyright © 2020 raylle. All rights reserved.
//

import UIKit

class Pessoa: NSObject {
    var nome: String
    var idade: Int
    
    override var description: String {
       return "\(self.nome) -  \(self.idade)"
    }
    
    init(nome: String, idade: Int) {
        self.nome = nome
        self.idade = idade
    }

}
