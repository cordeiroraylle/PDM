//
//  ViewController.swift
//  Banco de Dados
//
//  Created by raylle on 18/12/20.
//  Copyright © 2020 raylle. All rights reserved.
//

import UIKit
import CoreData

class MainViewController: UIViewController {
    
    @IBOutlet weak var tfNome: UITextField!
    @IBOutlet weak var tfIdade: UITextField!
    
    var delegate: AppDelegate!
    var contexto: NSManagedObjectContext!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.delegate = UIApplication.shared.delegate as? AppDelegate
        self.contexto = self.delegate.persistentContainer.viewContext
    }
    
    @IBAction func salvar(_ sender: Any) {
        let nome = self.tfNome.text
        let idade = Int(self.tfIdade.text!)
        let pessoa = NSEntityDescription.insertNewObject(forEntityName: "Pessoa", into: self.contexto)
        
        pessoa.setValue(nome, forKey: "nome")
        pessoa.setValue(idade, forKey: "idade")
        
        self.delegate.saveContext()
        print("saved")
        self.listar()
    }
    
    @IBAction func listar(_ sender: Any) {
        self.listar()
    }
    
    @IBAction func update(_ sender: Any) {
        
        let req = NSFetchRequest<NSFetchRequestResult>(entityName: "Pessoa")
        do {
            let pessoas = try self.contexto.fetch(req) as! [NSManagedObject]
            for pessoa in pessoas{
                pessoa.setValue(0, forKey: "idade")
            }
            self.delegate.saveContext()
            print("all set to 0")
        } catch {
            print("error")
        }
        
    }
    
    @IBAction func removeLast(_ sender: Any) {
        let req = NSFetchRequest<NSFetchRequestResult>(entityName: "Pessoa")
        do {
            let pessoas = try self.contexto.fetch(req) as! [NSManagedObject]
            let last = Int(pessoas.count)-1
            if last > -1 {
                let pessoa = pessoas[last]
                self.contexto.delete(pessoa)
                self.delegate.saveContext()
                print("\(last+1) was removed")
            }else{
                print("nothing to be removed")
            }
            
        } catch {
            print("error")
        }
    }
    
    
    func listar(){
        let req = NSFetchRequest<NSFetchRequestResult>(entityName: "Pessoa")
        do {
            let pessoas = try self.contexto.fetch(req) as! [NSManagedObject]
            for pessoa in pessoas{
                let nome = pessoa.value(forKey: "nome")
                let idade = pessoa.value(forKey: "idade")
                print("\(nome!) - \(idade!)")
            }
        } catch {
            print("error")
        }
    }
    
}

