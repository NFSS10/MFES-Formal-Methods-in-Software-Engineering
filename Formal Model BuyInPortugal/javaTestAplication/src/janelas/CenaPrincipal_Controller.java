package janelas;


import MFES_Proj.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;



public class CenaPrincipal_Controller
{
    private BuyInPortugal buyInPortugal;
    @FXML
    TextArea campoTexto;
    @FXML
    TextField lblRegNome;


    @FXML
    TextField txtTornarVendedor_Nome;


    @FXML
    TextField txtVerificarVendedor_Nome;


    @FXML
    TextField txtBloquearVendedor;


    @FXML
    TextField txtaddItems_NomeVendedor;
    @FXML
    TextField txtaddItems_NomeProd;
    @FXML
    TextField txtaddItems_Preco;
    @FXML
    TextField txtaddItems_Categ;
    @FXML
    TextField txtaddItems_Qtd;


    @FXML
    TextField txtAddFunds_NomeUser;
    @FXML
    TextField txtAddFunds_Valor;


    @FXML
    TextField txtAddCart_NomeComprador;
    @FXML
    TextField txtAddCart_Produto;
    @FXML
    TextField txtAddCart_Vendedor;


    @FXML
    TextField txtCheckout_Nome;
    @FXML
    TextField txtCheckout_Ano;
    @FXML
    TextField txtCheckout_Mes;
    @FXML
    TextField txtCheckout_Dia;






    public void init(BuyInPortugal buyInPt)
    {
        this.buyInPortugal = buyInPt;


        txtaddItems_Preco.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    txtaddItems_Preco.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        txtaddItems_Qtd.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    txtaddItems_Qtd.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        txtAddFunds_Valor.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    txtAddFunds_Valor.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });


        txtCheckout_Ano.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    txtCheckout_Ano.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        txtCheckout_Mes.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    txtCheckout_Mes.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        txtCheckout_Dia.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    txtCheckout_Dia.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });



        atualizarTextAreaInfo();
    }

    public void registarComprador()
    {
        if(!lblRegNome.getText().equals(""))
        {
            buyInPortugal.register(lblRegNome.getText(), "", new Object());
            atualizarTextAreaInfo();
        }

    }


    public void registarVendedor()
    {
        if(!txtTornarVendedor_Nome.getText().equals(""))
        {
            buyInPortugal.becomeSeller(txtTornarVendedor_Nome.getText());
            atualizarTextAreaInfo();
        }
    }

    public void verificarVendedor()
    {
        if(!txtVerificarVendedor_Nome.getText().equals(""))
        {
            buyInPortugal.verifySeller(txtVerificarVendedor_Nome.getText());
            atualizarTextAreaInfo();
        }
    }

    public void bloquearVendedor()
    {
        if(!txtBloquearVendedor.getText().equals(""))
        {
            buyInPortugal.blockSeller(txtBloquearVendedor.getText());
            atualizarTextAreaInfo();
        }
    }


    public void adicionarItmesParaVenda()
    {
        if(!txtaddItems_NomeVendedor.getText().equals("") && !txtaddItems_NomeProd.getText().equals("") && !txtaddItems_Preco.getText().equals("") && !txtaddItems_Categ.getText().equals("") && !txtaddItems_Qtd.getText().equals(""))
        {
            buyInPortugal.addItemToSale(txtaddItems_NomeVendedor.getText(), txtaddItems_NomeProd.getText(), Integer.parseInt(txtaddItems_Preco.getText()), txtaddItems_Categ.getText(), Integer.parseInt(txtaddItems_Qtd.getText()));
            atualizarTextAreaInfo();
        }
    }

    public void adicionarFundos()
    {
        if(!txtAddFunds_NomeUser.getText().equals("") && !txtAddFunds_Valor.getText().equals(""))
        {
            buyInPortugal.addFundsToUser(txtAddFunds_NomeUser.getText(),Integer.parseInt(txtAddFunds_Valor.getText()));
            atualizarTextAreaInfo();
        }
    }

    public void adicionarAoCarrinho()
    {
        if(!txtAddCart_NomeComprador.getText().equals("") && !txtAddCart_Produto.getText().equals("") && !txtAddCart_Vendedor.getText().equals(""))
        {
            buyInPortugal.addToCartOfUser(txtAddCart_NomeComprador.getText(),txtAddCart_Produto.getText(),txtAddCart_Vendedor.getText());
            atualizarTextAreaInfo();
        }
    }

    public void checkout()
    {
        if(!txtCheckout_Nome.getText().equals("") && !txtCheckout_Ano.getText().equals("") && !txtCheckout_Mes.getText().equals("") && !txtCheckout_Dia.getText().equals(""))
        {
            buyInPortugal.checkoutCartOfUser(txtCheckout_Nome.getText(),Integer.parseInt(txtCheckout_Ano.getText()),Integer.parseInt(txtCheckout_Mes.getText()),Integer.parseInt(txtCheckout_Dia.getText()));
            atualizarTextAreaInfo();
        }
    }








    private void atualizarTextAreaInfo()
    {
        campoTexto.setText("Compradores:\n"+getCompradores()+"\n" +
            "Vendedores:\n"+getVendedores());
    }

    private String getCompradores()
    {
        String str ="";
        String cartStr="";
        String historicoStr ="";
        String orderStr = "";
        Buyer buyer;
        Order order;
        Product product;
        for (Object key : buyInPortugal.getBuyers().keySet())
        {
            buyer = (Buyer)(buyInPortugal.getBuyers().get(key));
            str += "Nome: "+buyer.getName() + "  -  Dinheiro: " + buyer.getCurrentCash();


            str+="\n            Cart(total:"+buyer.getCartItems().size()+"): [";
            for (int j = 0; j < buyer.getCartItems().size();j++)
                cartStr+= buyer.getCartItems().get(j).toString();
            str += cartStr + "]\n";


            str+= "\n            Historico encomendas(total: "+buyer.getOrderHistory().size()+"): [";
            for (int i =0; i<buyer.getOrderHistory().size();i++)
            {
                order = (Order)buyer.getOrderHistory().get(i);
                historicoStr+="{"+(i+1)+" - ( "+order.getDate().day+"/"+order.getDate().month+"/"+order.getDate().year+" | ";
                for (int j =0; j< order.getSaleItemsBought().size();j++)
                {
                    product = (Product)order.getSaleItemsBought().get(j);
                    orderStr += "<"+ product.getName()+" - "+product.getPrice()+" - " +product.getCategory()+ ">";
                }
                historicoStr+=orderStr+")} ";
            }
            str += historicoStr + "]\n";
        }
        return str+"\n";
    }


    private String getVendedores()
    {
        String str ="";
        String prodAvenda="";
        Seller seller;
        Product item;
        for (Object key : buyInPortugal.getSellers().keySet())
        {
            seller = (Seller) (buyInPortugal.getSellers().get(key));
            str += "Nome: "+seller.getName() + "  -  Estado: "+ seller.status +
                    "\n            Produtos à venda(total: "+seller.getSaleItemsBeingSoldByMe().size()+"): [";


            for (Object k : seller.getSaleItemsBeingSoldByMe().keySet())
            {
                item = (Product) seller.getSaleItemsBeingSoldByMe().get(k);
                prodAvenda+="("+item.getName()+" - "+item.getCategory()+" - "+item.getPrice()+"€ - Qtd. " + item.getStockQt()+") ";
            }
            str += prodAvenda + "]\n";


        }


        return str+"\n";
    }



}
