package com.mateusgil;

import java.util.Scanner;

public class Banco {

    protected String tipoConta; //cc cp

    private float saldo;
    private boolean status;





    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }


    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


    Scanner ler = new Scanner(System.in);

    public void abrirConta() {
        System.out.println("=================ABERTURA DE CONTA====================");
        System.out.println("Tipo de conta [CC]Conta corrente  [CP]Conta poupanca: ");
        String tipoConta = ler.nextLine().toUpperCase();
        if (tipoConta.equals("CC")) {
            setSaldo(50);
            System.out.println("Voce possui atualmente R$" + getSaldo() + " na sua conta");
            setStatus(true);
        } else if (tipoConta.equals("CP")) {
            setSaldo(150);
            System.out.println("Voce possui atualmente R$" + getSaldo() + " na sua conta");
            setStatus(true);
        } else {
            abrirConta();
        }

        while (this.status = true) {
            System.out.println("[1]fechar conta  [2]depositar  [3]sacar:");
            int acao = ler.nextInt();
            if (acao == 1) {
                fecharConta();
                setStatus(false);
            } else {
                while (acao != 1) {
                    if (acao == 2) {
                        depositar();
                        break;
                    }
                    if (acao == 3) {
                        sacar();
                        break;
                    }
                    else {
                        abrirConta();
                    }
                }
            }

        }
        System.out.println("===================================");
    }

    public void fecharConta() {
        if (getSaldo() > 0) {
            System.out.println("Nao pode fechar conta enquanto o saldo e positivo. Saque o dinheiro !!!");
            setStatus(true);
        } else {
            setStatus(false);
            System.out.println("CONTA FECHADA");
            abrirConta();
        }
    }

    public void depositar() {
        if (this.status == true) {
            System.out.println("Digite a quantidade que deseja depositar R$: ");
            long valDeposito = ler.nextInt();
            saldo = valDeposito + saldo;
            System.out.println("R$" + valDeposito + " foi depositado na sua conta");
            System.out.println("Voce possui atualmente R$" + getSaldo() + " na sua conta");
        } System.out.println("======================================");
    }

    public void sacar() {
        if (this.saldo > 0) {
            setStatus(true);
            System.out.println("Digite a quantidade que deseja sacar: ");
            int valSacado = ler.nextInt();
            if (valSacado <= saldo) {
                System.out.println("R$" + valSacado + " foi sacado");
                saldo = saldo - valSacado;
                System.out.println("Vc tem agora R$" + getSaldo() + " na sua conta");
            } else {
                System.out.println("O valor que deseja sacar e maior do que esta na conta !!!");
                System.out.println("Voce possui atualmente R$" + getSaldo() + " na sua conta");
            }

        } System.out.println("======================================");
    }
}

