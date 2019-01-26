# Installation And Configuration

    cp arbitrage/config.py-example arbitrage/config.py

Then edit config.py file to setup your preferences: watched markets
and observers

You need Python3 to run this program. To install on Debian, Ubuntu, or
variants of them, use:

    $ sudo apt-get install python3 python3-pip python-nose

To use the observer XMPPMessager you will need to install sleekxmpp:

    $ pip3 install sleekxmpp

# Run

To run the opportunity watcher:

    $ python3 -m arbitrage
    2013-03-12 03:52:14,341 [INFO] profit: 30.539722 EUR with volume: 10 BTC - buy at 29.3410 (MtGoxEUR) sell at 29.4670 (Bitcoin24EUR) ~10.41%
    2013-03-12 03:52:14,356 [INFO] profit: 66.283642 EUR with volume: 10 BTC - buy at 29.3410 (MtGoxEUR) sell at 30.0000 (PaymiumEUR) ~22.59%
    2013-03-12 03:52:14,357 [INFO] profit: 31.811390 EUR with volume: 10 BTC - buy at 29.3410 (MtGoxEUR) sell at 30.0000 (IntersangoEUR) ~10.84%
    2013-03-12 03:52:45,090 [INFO] profit: 9.774324 EUR with volume: 10 BTC - buy at 35.3630 (Bitcoin24EUR) sell at 35.4300 (PaymiumEUR) ~2.76%

To check your balance on an exchange (also a good way to check your accounts configuration):

    $ python3 -m arbitrage -m Paymium get-balance
    $ python3 -m arbitrage -m Paymium,BitstampUSD get-balance

Run tests

    $ nosetests arbitrage/

## Alternative usage

List supported public markets:

    $ python3 -m arbitrage list-public-markets

Help:

    $ python3 -m arbitrage -h

# Cron
    cron /DIRECTORY/cronfile
    crontab -e

# Screen
List screens:
    
    screen -ls

Attach arbitrage or orderbook screen:

    screen -r arbitrage
    screen -r orderbook

Detach run:

    ctrl + a + d


To get the balance, you will need to install ccxt:

    $ pip -e install ccxt/python


### Get Balances
https://github.com/ccxt/ccxt

1) bitcambio - :heavy_check_mark: OK 
2) braziliex - :heavy_check_mark: OK 
3) btc2you - :x:
4) btcbolsa - :x:
5) btctrade - :x:
6) coinext - :x:
7) foxbit - :x:
8) mercado - :heavy_check_mark: OK 
9) omnitrade - :heavy_check_mark: OK 
10) flowbtc - :x:
11) modiax - :x:

## Installation guide ccxt

Creating Env in Pycharm:

`File->Setings-> Project-> Interpreter-> Configuration-> Add-> New -> Ok`


Installing  ccxt library , in pycharm terminal:

`$ pip install -e ccxt/python/`


Activating environment: 
&nbsp;
`
$ source venv/bin/activate`

