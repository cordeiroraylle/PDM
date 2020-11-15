//
//  Arroche.swift
//  ArrocheIOS
//
//  Created by raylle on 14/11/20.
//

import UIKit

class Arroche: NSObject {
    
    var numero : Int
    var linicial : Int
    var lfinal: Int
    var jogando : Bool
    var resultado : String
    
    
    override init() {
        self.numero = Int.random(in: 2...99)
        self.linicial = 1
        self.lfinal = 100
        self.jogando = true
        self.resultado = "jogando"
    }
    
    func display() -> String{
        return ("numero sorteado: \(numero), limite inicial: \(linicial), limite final: \(lfinal)")
    }
    
    
    func chutar(chute : Int){
        
        if (chute == numero || chute == linicial || chute == lfinal || chute > lfinal || chute < linicial ) {
            self.resultado = "você perdeu"
            self.jogando = false
        }else{
            if chute < numero {
                linicial = chute
            }else{
                lfinal = chute
            }
        }
        if (linicial == (numero - 1) && lfinal == (numero + 1) ){
            self.resultado = "você ganhou"
            self.jogando = false
        }
        
    }
    
}
