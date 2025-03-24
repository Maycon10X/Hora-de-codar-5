import java.util.*
import kotlin.system.exitProcess

var saldo = 100.5 // Float
var nome = ""
var senha = 3589
fun main() {
    println("Olá qual o seu nome? ")
    var nome = readln()
    println("Olá $nome Seja bem vindo ao caixa eletrônico!\n Coloque a senha para continuar")

    var confirma = readln().toIntOrNull()
    while (confirma != senha){
        println("A sua senha está incorreta digite novamente! ")
        confirma = readln().toIntOrNull()
     if (confirma == senha) {
         println("Senha validada com sucesso!")
     }
        }
    inicio()
}


fun inicio() {
    println("Escolha uma das opções do Menu!" +
            "\n 1-Ver Saldo\n 2-Ver Extrato\n 3-Fazer Saque\n 4-Fazer Depósito \n" +
            " 5-Fazer tranferência \n 6-Sair ")
    val escolha = readLine()?.toIntOrNull()

    when (escolha) {
        1 -> verSaldo()
        3 -> fazerSaque()
        4 -> fazerDeposito()
        2 -> verExtrato()
        5 -> fazerTransferencia()
        6 -> saia()
        else -> erro()
    }
}

fun verSaldo() {
    



    println("Seu saldo atual é: $saldo")
    inicio()
}

fun fazerDeposito() {
    print("Qual o valor para depósito? ")
    var deposito = readLine()?.toFloatOrNull()

    if (deposito == null) {
        println("Por favor, informe um número válido.")
        fazerDeposito()
    }
    while (deposito != null) {
        if (deposito <= 0) {
            println("Digite um valor maior que 0!")
            deposito = readln()?.toFloatOrNull()
        } else {
            saldo += deposito
            verSaldo()
        }
    }
}
fun fazerSaque() {
    print("Qual o valor para saque? \n")
    val saque = readln()?.toFloatOrNull()

    if (saque == null) {
        println("Por favor, informe um número válido.")
        fazerSaque()
    }
        if (saldo < saque!!) {
            println("Operação inválida!.\nValor maior que o saldo bancário!")
            fazerSaque()
        }
            if (saque <= 0) {
            println("Operação inválida!.\nO saque não pode ser menor ou igual a zero!")
            fazerSaque()

        }
            else {
            saldo -= saque
            verSaldo()
        }
    }


fun erro() {
    println("Por favor, informe um número entre 1 e 6.")
    inicio()
}
fun verExtrato(){
      println("Aqui estão seu dados de tranfências bancárias:\n 22/03/2025 - Banco PicPay | Valor - 100R$ \n" +
              " 21/03/2025 - Banco Bradesco | Valor - 24R$ \n 20/03/2025 - Banco PicPay | Valor - 1.600R\$")
    inicio()
}
fun fazerTransferencia() {
    println("Para qual conta você deseja fazer a tranferência? ")
    var conta = readLine()?.toIntOrNull()
    if (conta == null) {
        println("Por favor, informe um número válido.")
        fazerTransferencia()
    } else {
        println(
            "A conta escolhida para tranferência foi $conta\n" +
                    " Qual valor deseja tranferir para essa conta?"
        )

        var transfer = readln()?.toFloatOrNull()
        while (transfer == null) {
            println("Valor inválido!\nDigite o nvalor novamente")
            transfer = readln()?.toFloatOrNull()
        }
        while (transfer != null) {
            if (transfer > saldo) {
                println("Digite um valor Verdadadeiro!\n Seu saldo é $saldo")
                transfer = readln()?.toFloatOrNull()
            } else if (transfer <= 0) {
                println("Digite um valor maior que zero!")
                transfer = readln()?.toFloatOrNull()
            } else {
                saldo -= transfer

                println("Transferência concluída!\n seu novo saldo é $saldo")

                inicio()
            }
        }
    }
}
  fun saia() {
      print("Você deseja sair? (S/N) ")
      val confirma = readLine()?.uppercase(Locale.getDefault())

      when (confirma) {
          "S" ->{ println("Obrigado por usar o nosso sistema! $nome")
              exitProcess(0)}
          "N" -> inicio()
          else -> saia()

      }
  }
